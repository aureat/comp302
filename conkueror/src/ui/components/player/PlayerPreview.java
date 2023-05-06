package ui.components.player;

import domain.player.Player;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageButton;
import ui.components.core.RoundedImage;

import javax.swing.*;
import java.awt.*;


public class PlayerPreview extends ImageButton {

    private final Player player;
    private final RoundedImage avatarImage;
    private final JLabel nameLabel;

    public PlayerPreview(Player player) {
        super(
                Assets.ColorCard.getAsset(player.getColor().toString().toLowerCase()).getImageIcon(),
                40,
                40
        );

        setSize(180, 238);
        setLayout(new BorderLayout());

        // set player
        this.player = player;

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        // avatar image
        JPanel avatarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        avatarPanel.setOpaque(false);
        Asset avatar = Assets.AvatarMd.getAsset(player.getAvatar().toString());
        avatarImage = new RoundedImage(avatar.getImageIcon(), 30, 30);
        avatarImage.setPreferredSize(new Dimension(150, 150));
        avatarPanel.add(avatarImage);

        // name label
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        namePanel.setOpaque(false);
        nameLabel = new JLabel(player.getFirstName());
        nameLabel.setFont(Fonts.GilroyBold.deriveFont(18f));
        nameLabel.setForeground(new Color(0x4F6B76));
        namePanel.add(nameLabel);

        // add to screen
        info.add(Box.createVerticalGlue());
        info.add(avatarPanel);
        info.add(Box.createVerticalGlue());
        info.add(namePanel);
        info.add(Box.createVerticalGlue());
        add(info, BorderLayout.CENTER);

    }

    public Player getPlayer() {
        return player;
    }

    public void update() {
        nameLabel.setText(player.getFirstName());
        Asset avatar = Assets.AvatarMd.getAsset(player.getAvatar().toString());
        avatarImage.setIcon(avatar.getImageIcon());
        setIcon(Assets.ColorCard.getAsset(player.getColor().toString().toLowerCase()).getImageIcon());
        avatarImage.repaint();
        repaint();
    }

}