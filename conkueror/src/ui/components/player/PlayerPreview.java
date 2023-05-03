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

    public PlayerPreview(Player player) {
        super(Assets.ColorCard.getAsset(player.getColor().toString().toLowerCase()).getImageIcon(), 40, 40);
        setSize(180, 238);

        setLayout(new BorderLayout());

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        JPanel avatarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        avatarPanel.setOpaque(false);
        Asset avatar = Assets.AvatarMd.getAsset(player.getAvatar().toString());
        RoundedImage preview = new RoundedImage(avatar.getImageIcon(), 30, 30);
        preview.setPreferredSize(new Dimension(150, 150));
        avatarPanel.add(preview);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        namePanel.setOpaque(false);
        JLabel name = new JLabel(player.getFirstName());
        name.setFont(Fonts.GilroyBold.deriveFont(18f));
        name.setForeground(new Color(0x4F6B76));
        namePanel.add(name);

        info.add(Box.createVerticalGlue());
        info.add(avatarPanel);
        info.add(Box.createVerticalGlue());
        info.add(namePanel);
        info.add(Box.createVerticalGlue());

        add(info, BorderLayout.CENTER);

    }


}