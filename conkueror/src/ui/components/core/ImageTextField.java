package ui.components.core;

import ui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * A text field that displays an image.
 * Has a rounded rectangle outline.
 * @since 0.5.0
 */
public class ImageTextField extends JTextField {

    private final int width;
    private final int height;
    private final Image image;
    private Insets insets;
    private final RoundRectangle2D.Float outline;

    public ImageTextField(ImageIcon icon, int arc, int columns) {
        super(columns);
        width = icon.getIconWidth();
        height = icon.getIconHeight();
        image = icon.getImage();
        outline = new RoundRectangle2D.Float(0, 0, width, height, arc, arc);
        insets = new Insets(10, 30, 10, 30);
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setOpaque(false);
        setBorder(null);
    }

    public void setInsets(int top, int left, int bottom, int right) {
        insets = new Insets(top, left, bottom, right);
    }

    @Override
    public Insets getInsets() {
        return insets;
    }

    @Override
    public boolean contains(int x, int y) {
        return outline.contains(x, y);
    }

    public boolean contains(Point p) {
        return outline.contains(p);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = SwingUtils.getGraphics2D(g.create());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setClip(outline);
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
        super.paintComponent(g);
    }

}
