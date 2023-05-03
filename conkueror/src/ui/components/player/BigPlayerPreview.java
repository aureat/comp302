package ui.components.player;

import domain.player.Player;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.assets.Fonts;
import ui.components.core.ImageButton;
import ui.components.core.RoundedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class BigPlayerPreview extends ImageButton {

    RoundedImage preview;
    private final Player player;
    private final JLabel nameLabel;

    public BigPlayerPreview(Player player) {
        super(
                Assets.ColorCardLg.getAsset(player.getColor().toString().toLowerCase()).getImageIcon(),
                40, 40
        );

        this.player = player;
        setCursor(Cursor.getDefaultCursor());
        setLayout(new FlowLayout(FlowLayout.CENTER, 25, 25));
        setSize(300, 397);

        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        JPanel avatarPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        avatarPanel.setOpaque(false);
        Asset avatar = Assets.AvatarLg.getAsset(player.getAvatar().toString());
        preview = new RoundedImage(avatar.getImageIcon(), 50, 50);
        avatarPanel.add(preview);

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        namePanel.setOpaque(false);
        nameLabel = new JLabel(player.getFirstName());
        nameLabel.setFont(Fonts.GilroyExtraBold.deriveFont(36f));
        nameLabel.setForeground(new Color(0x4F6B76));
        namePanel.add(nameLabel);

        info.setSize(250, 380);

        info.add(Box.createVerticalGlue());
        info.add(avatarPanel);
        info.add(Box.createVerticalStrut(25));
        info.add(namePanel);
        info.add(Box.createVerticalGlue());

        add(info);
    }

    public ImageIcon getBackgroundCard() {
        return Assets.ColorCardLg.getAsset(player.getColor().toString().toLowerCase()).getImageIcon();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void updateText() {
        nameLabel.setText(player.getFirstName());
    }

    public void updateAvatar() {
        Asset avatar = Assets.AvatarLg.getAsset(player.getAvatar().toString());
        preview.setIcon(avatar.getImageIcon());
        preview.revalidate();
        preview.repaint();
    }

    public void updateColor() {
        setIcon(getBackgroundCard());
    }

}