package ui.components.map;

import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Territory extends JPanel implements MouseListener {

    private Shape shape;

    private double x;
    private double y;

    private boolean isHovered;

    private Color defaultColor = Color.BLUE;
    private Color hoverColor = Color.RED;
    private Color clickColor = Color.CYAN;

    private Color strokeColor;
    private Color fillColor;

    public Territory(Shape shape) {
        this.shape = shape;
        this.x = 0;
        this.y = 0;
        this.isHovered = false;
        this.strokeColor = defaultColor;
        addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(strokeColor);
        g2d.setClip(shape);
        g2d.setStroke(new BasicStroke(MapGraphics.territoryStroke));
        g2d.draw(shape);
        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (shape.getBounds().contains(e.getPoint())) {
            strokeColor = hoverColor;
            repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        strokeColor = defaultColor;
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        strokeColor = clickColor;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseReleased(MouseEvent e ) {
        // ...
    }

}
