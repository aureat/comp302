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
import java.util.stream.Stream;

@View(at = Route.EditPlayer)
public class EditPlayerView extends ViewPanel<EditPlayerController> {

    private BigPlayerPreview preview;
    private ImageTextField nameField;

    public EditPlayerView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("sunburst");
        Assets.ButtonMd.loadAsset("male");
        Assets.ButtonMd.loadAsset("female");
        Assets.ButtonLg.loadAsset("save");
        Assets.MenuLg.loadAsset("shuffle");
        Assets.ButtonSave.loadAsset("save");
        Assets.InputText.loadAsset("player-name");
        Avatars.all.forEach(avatar -> Assets.AvatarRounded.loadAsset(avatar.toString()));
        Avatars.all.forEach(avatar -> Assets.AvatarLg.loadAsset(avatar.toString()));
        Stream.of("yellow", "green", "purple", "red", "orange", "blue").forEach(color -> {
            Assets.ColorBall.loadAsset(color);
            Assets.ColorCardLg.loadAsset(color);
        });
    }

    @Override
    public void onMount() {
        preview.setPlayer(getController().getPlayer());
        preview.update();
        nameField.setText(getController().getPlayer().getFullName());
    }

    public void initialize() {
        setViewBackground(Assets.Background.getAsset("sunburst"));

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER, 60, 0));
        container.setOpaque(false);

        // Left Container
        JPanel leftContainer = new JPanel();
        leftContainer.setLayout(new BoxLayout(leftContainer, BoxLayout.Y_AXIS));
        leftContainer.setOpaque(false);
        leftContainer.setMaximumSize(new Dimension(300, getContainerHeight()));

        // Avatar Preview
        preview = new BigPlayerPreview(getController().getPlayer());
        preview.setMaximumSize(new Dimension(300, 397));
        getController().setPreview(preview);

        // Male Female Buttons
        ImageBtnStack maleFemaleButtons = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 140, 49, 10, 30);
        ImageButton btnMales = maleFemaleButtons.addButton(Assets.ButtonMd.getAsset("male"));
        ImageButton btnFemales = maleFemaleButtons.addButton(Assets.ButtonMd.getAsset("female"));
        maleFemaleButtons.setMaximumSize(maleFemaleButtons.getPreferredSize());

        // Add to left container
        leftContainer.add(preview);
        leftContainer.add(Box.createVerticalStrut(30));
        leftContainer.add(maleFemaleButtons);
        leftContainer.setMaximumSize(leftContainer.getPreferredSize());

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
            button.addActionListener(e -> getController().setAvatar(avatar));
            avatarGridMales.add(button);
        });
        avatarGridMales.setMaximumSize(avatarGridMales.getPreferredSize());
        avatarGridMales.setOpaque(false);
        avatarGridMales.setVisible(true);

        // Female Avatar Grid
        JPanel avatarGridFemales = new JPanel(new GridLayout(3, 5, 10, 10));
        Avatars.females.forEach(avatar -> {
            ImageButton button = new ImageButton(
                    Assets.AvatarRounded.getAsset(avatar.toString())
                            .getImageIcon(), 10, 10);
            button.addActionListener(e -> getController().setAvatar(avatar));
            avatarGridFemales.add(button);
        });
        avatarGridFemales.setMaximumSize(avatarGridFemales.getPreferredSize());
        avatarGridFemales.setOpaque(false);
        avatarGridFemales.setVisible(false);

        // Name Field
        nameField = new ImageTextField(
                Assets.InputText.getAsset("player-name").getImageIcon(), 30, 30);
        nameField.setInsets(12, 20, 10, 20);
        nameField.setForeground(Color.BLACK);
        nameField.setFont(Fonts.GilroyExtraBold.deriveFont(24f));
        nameField.setText(getController().getPlayer().getFullName());
        nameField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                getController().setName(nameField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getController().setName(nameField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {}
        });

        // Colors
        ImageBtnStack colorButtons = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 39, 40, 8, 100);
        Stream.of("yellow", "green", "purple", "red", "orange", "blue").forEach(color -> {
            colorButtons.addButton(Assets.ColorBall.getAsset(color))
                    .addActionListener(e -> getController().setColor(color));
        });

        // Form Buttons
        JPanel formButtons = new JPanel();
        formButtons.setLayout(new BoxLayout(formButtons, BoxLayout.X_AXIS));
        formButtons.setOpaque(false);
        formButtons.setMaximumSize(avatarGridMales.getMaximumSize());
        ImageButton shuffleButton = new ImageButton(
                Assets.MenuLg.getAsset("shuffle").getImageIcon(), 20, 20);
        ImageButton aiButton = new ImageButton(
                Assets.MenuLg.getAsset("ai").getImageIcon(), 20, 20);
        ImageButton saveButton = new ImageButton(
                Assets.ButtonSave.getAsset("save").getImageIcon(), 20, 20);
        formButtons.add(shuffleButton);
        formButtons.add(Box.createHorizontalStrut(16));
        formButtons.add(aiButton);
        formButtons.add(Box.createHorizontalGlue());
        formButtons.add(saveButton);
        shuffleButton.addActionListener(e -> getController().randomizePlayer(preview));
        aiButton.addActionListener(e -> getController().setAI());
        saveButton.addActionListener(e -> getController().savePlayer());

        // Add all to right container
        rightContainer.add(avatarGridMales);
        rightContainer.add(avatarGridFemales);
        rightContainer.add(Box.createVerticalStrut(40));
        rightContainer.add(nameField);
        rightContainer.add(Box.createVerticalStrut(20));
        rightContainer.add(colorButtons);
        rightContainer.add(Box.createVerticalStrut(60));
        rightContainer.add(formButtons);

        btnMales.addActionListener(e -> {
            avatarGridMales.setVisible(true);
            avatarGridFemales.setVisible(false);
        });

        btnFemales.addActionListener(e -> {
            avatarGridMales.setVisible(false);
            avatarGridFemales.setVisible(true);
        });

        container.add(leftContainer);
        container.add(rightContainer);
        centerComponent(container);
        add(container);
    }

}
