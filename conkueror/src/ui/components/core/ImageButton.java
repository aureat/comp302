package ui.components.core;

import ui.util.SwingUtils;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.*;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

/**
 * A button that displays an image.
 * Has a rounded rectangle outline.
 * @since 1.0.0
 */
public class ImageButton extends JComponent implements MouseListener {

    private int width;
    private int height;
    private int arcw;
    private int arch;

    private Image image;
    private RoundRectangle2D.Float outline;

    private final List<ActionListener> listeners = new ArrayList<>();

    public ImageButton(ImageIcon imageIcon, int arcw, int arch) {
        this.arcw = arcw;
        this.arch = arch;
        initButton(imageIcon);
        setOpaque(false);
        setBorder(null);
        addMouseListener(this);
    }

    public ImageButton(String path, int arc) {
        this(new ImageIcon(path), arc, arc);
    }

    private void initButton(ImageIcon imageIcon) {
        this.image = imageIcon.getImage();
        this.width = imageIcon.getIconWidth();
        this.height = imageIcon.getIconHeight();
        outline = new RoundRectangle2D.Float(0, 0, width, height, arcw, arch);
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
    }

    public void setIcon(ImageIcon imageIcon) {
        initButton(imageIcon);
        repaint();
    }

    @Override
    public boolean contains(int x, int y) {
        return outline.contains(x, y);
    }

    public boolean contains(Point p) {
        return outline.contains(p);
    }

    public void addActionListener(ActionListener listener) {
        listeners.add(listener);
    }

    public void notifyListeners(ActionEvent e) {
        for (ActionListener listener : listeners) {
            listener.actionPerformed(e);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (contains(e.getPoint())) {
            notifyListeners(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "click"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        if (contains(e.getPoint())) {
            setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        } else {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(Cursor.getDefaultCursor());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = SwingUtils.getGraphics2D(g.create());
        g2.setClip(outline);
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
    }

}
