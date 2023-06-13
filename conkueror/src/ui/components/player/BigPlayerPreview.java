package ui.components.player;

import domain.player.Player;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.AssetRenderer;
import ui.components.core.ImageButton;
import ui.components.core.RoundedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class BigPlayerPreview extends ImageButton {

    private Player player;
    private final RoundedImage avatarImage;
    private final JLabel nameLabel;
    private final AssetRenderer aiLabel;

    public BigPlayerPreview(Player player) {
        super(
                Assets.ColorCardLg.getAsset(player.getColor().toString().toLowerCase()).getImageIcon(),
                40,
                40
        );

        setCursor(Cursor.getDefaultCursor());
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        setSize(300, 397);

        this.player = player;

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        // avatar image
        JPanel avatarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        avatarPanel.setOpaque(false);
        Asset avatar = Assets.AvatarLg.getAsset(player.getAvatar().toString());
        avatarImage = new RoundedImage(avatar.getImageIcon(), 50, 50);
        avatarPanel.add(avatarImage);

        // name label
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        namePanel.setOpaque(false);
        nameLabel = new JLabel(player.getFirstName());
        nameLabel.setMaximumSize(new Dimension(240, 50));
        nameLabel.setFont(Fonts.GilroyExtraBold.deriveFont(36f));
        nameLabel.setForeground(new Color(0x4F6B76));
        namePanel.add(nameLabel);

        aiLabel = new AssetRenderer(Assets.PanelAI.getAsset("robot"));
        aiLabel.setBounds(0, 0, 40, 40);
        aiLabel.setVisible(player.isComputer());
        namePanel.add(aiLabel);

        // add to screen
        info.setSize(250, 380);
        info.add(Box.createVerticalGlue());
        info.add(avatarPanel);
        info.add(Box.createVerticalStrut(25));
        info.add(namePanel);
        info.add(Box.createVerticalGlue());
        add(info);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void update() {
        updateText();
        updateAvatar();
        updateColor();
        updateAI();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void updateText() {
        nameLabel.setText(player.getFirstName());
    }

    public void updateAvatar() {
        Asset avatar = Assets.AvatarLg.getAsset(player.getAvatar().toString());
        avatarImage.setIcon(avatar.getImageIcon());
        avatarImage.repaint();
    }

    public void updateColor() {
        setIcon(Assets.ColorCardLg.getAsset(player.getColor().toString().toLowerCase()).getImageIcon());
    }

    public void updateAI() {
        aiLabel.setVisible(player.isComputer());
    }

}