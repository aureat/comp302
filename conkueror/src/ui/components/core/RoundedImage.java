package ui.components.core;

import ui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;

public class RoundedImage extends JComponent {

    private final int width;
    private final int height;
    private final int arcw;
    private final int arch;

    private Image image;
    private final ImageIcon imageIcon;
    private final RoundRectangle2D.Float outline;
    private final Area outlineArea;

    public RoundedImage(ImageIcon imageIcon, int arcw, int arch) {
        this.arcw = arcw;
        this.arch = arch;
        this.imageIcon = imageIcon;
        this.image = imageIcon.getImage();
        this.width = imageIcon.getIconWidth();
        this.height = imageIcon.getIconHeight();
        outline = new RoundRectangle2D.Float(0, 0, width, height, arcw, arch);
        outlineArea = new Area(outline);
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setOpaque(false);
        setBorder(null);
    }

    public void setIcon(ImageIcon imageIcon) {
        this.image = imageIcon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = SwingUtils.setQualityGraphics2D((Graphics2D) g.create());
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setClip(outline);
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
    }

}
