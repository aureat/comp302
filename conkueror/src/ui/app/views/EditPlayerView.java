package ui.app.views;

import domain.player.Avatars;
import domain.player.Colors;
import ui.app.controllers.EditPlayerController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageBtnStack;
import ui.components.core.ImageButton;
import ui.components.core.ImageTextField;
import ui.components.player.BigPlayerPreview;
import ui.components.player.PlayerPreview;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

@View(at = Route.EditPlayer)
public class EditPlayerView extends ViewPanel<EditPlayerController> {

    public EditPlayerView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("sunburst");
    }

    public void initialize() {

        setViewBackground(Assets.Background.getAsset("sunburst"));

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));
        container.setOpaque(false);

        // Left Container
        JPanel leftContainer = new JPanel();
        leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.Y_AXIS));
        leftContainer.setOpaque(false);

        // Avatar Preview
        BigPlayerPreview preview = new BigPlayerPreview(getController().getPlayer());

        // Male Female Buttons
        ImageBtnStack maleFemaleButtons = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 140, 49, 20, 30);
        ImageButton btnMales = maleFemaleButtons.addButton(Assets.ButtonMd.getAsset("male"));
        ImageButton btnFemales = maleFemaleButtons.addButton(Assets.ButtonMd.getAsset("female"));

        // Add to left container
        leftContainer.add(preview);
        leftContainer.add(Box.createVerticalStrut(30));
        leftContainer.add(maleFemaleButtons);
        container.add(leftContainer);

        // Right Container
        JPanel rightContainer = new JPanel();
        rightContainer.setLayout(new BoxLayout(rightContainer, BoxLayout.Y_AXIS));
        rightContainer.setOpaque(false);

        // Male Avatar Grid
        JPanel avatarGridMales = new JPanel(new GridLayout(3, 5, 10, 10));
        Avatars.males.forEach(avatar -> {
            ImageButton button = new ImageButton(
                    Assets.AvatarRounded.getAsset(avatar.toString())
                            .getImageIcon(), 10, 10);
            button.addActionListener(e -> {
                getController().getPlayer().setAvatar(avatar);
                preview.updateAvatar();
            });
            avatarGridMales.add(button);
        });
        avatarGridMales.setOpaque(false);
        avatarGridMales.setVisible(true);

        // Female Avatar Grid
        JPanel avatarGridFemales = new JPanel(new GridLayout(3, 5, 10, 10));
        Avatars.females.forEach(avatar -> {
            ImageButton button = new ImageButton(
                    Assets.AvatarRounded.getAsset(avatar.toString())
                            .getImageIcon(), 10, 10);
            button.addActionListener(e -> {
                getController().getPlayer().setAvatar(avatar);
                preview.updateAvatar();
            });
            avatarGridFemales.add(button);
        });
        avatarGridFemales.setOpaque(false);
        avatarGridFemales.setVisible(false);

        // Name Field
        ImageTextField nameField = new ImageTextField(
                Assets.InputText.getAsset("player-name").getImageIcon(), 30, 30);
        nameField.setInsets(10, 20, 10, 20);
        nameField.setForeground(Color.BLACK);
        nameField.setFont(Fonts.GilroyExtraBold.deriveFont(24f));
        nameField.setText(getController().getPlayer().getFullName());
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getController().getPlayer().setName(nameField.getText());
                preview.updateText();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getController().getPlayer().setName(nameField.getText());
                preview.updateText();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        // Colors
        ImageBtnStack colorButtons = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 39, 40, 8, 100);
        colorButtons.addButton(Assets.ColorBall.getAsset("yellow"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Yellow);
                    preview.updateColor();
                });
        colorButtons.addButton(Assets.ColorBall.getAsset("green"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Green);
                    preview.updateColor();
                });
        colorButtons.addButton(Assets.ColorBall.getAsset("purple"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Purple);
                    preview.updateColor();
                });
        colorButtons.addButton(Assets.ColorBall.getAsset("red"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Red);
                    preview.updateColor();
                });
        colorButtons.addButton(Assets.ColorBall.getAsset("orange"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Orange);
                    preview.updateColor();
                });
        colorButtons.addButton(Assets.ColorBall.getAsset("blue"))
                .addActionListener(e -> {
                    getController().getPlayer().setColor(Colors.ColorType.Blue);
                    preview.updateColor();
                });

        // Add all to right container
        rightContainer.add(avatarGridMales);
        rightContainer.add(avatarGridFemales);
        rightContainer.add(Box.createVerticalStrut(20));
        rightContainer.add(nameField);
        rightContainer.add(Box.createVerticalStrut(20));
        rightContainer.add(colorButtons);
        container.add(rightContainer);

        btnMales.addActionListener(e -> {
            avatarGridMales.setVisible(true);
            avatarGridFemales.setVisible(false);
        });

        btnFemales.addActionListener(e -> {
            avatarGridMales.setVisible(false);
            avatarGridFemales.setVisible(true);
        });

        setSizeOnCenter(container);
        add(container);

    }

}
