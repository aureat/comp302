package ui.components;

import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class WorldMap extends JPanel implements MouseListener {

    private MapGraphics mapGraphics = MapGraphics.getInstance();

    public WorldMap() {
        initComponent();
    }

    public void initComponent() {
        setLayout(null);
        setSize(1534, 985);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        if (shape.getBounds().contains(e.getPoint())) {
//            strokeColor = hoverColor;
//            repaint();
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        strokeColor = defaultColor;
//        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        strokeColor = clickColor;
//        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // ...
    }

    @Override
    public void mouseReleased(MouseEvent e ) {
        // ...
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        paintContinents(g2d);
        paintNorthAmerica(g2d);
        g2d.dispose();
        super.paintComponent(g);
    }

    public void paintContinents(Graphics2D g) {
        g = (Graphics2D) g.create();
        g.setStroke(new BasicStroke(MapGraphics.continentStroke));
        g.translate(14, 43);

        g.draw(mapGraphics.shapeNorthAmericaOutline);
    }

    public void paintNorthAmerica(Graphics2D g) {
        g = (Graphics2D) g.create();
        g.setStroke(new BasicStroke(MapGraphics.territoryStroke));
        g = (Graphics2D) g.create();
        g.translate(8, 53);
        g.draw(mapGraphics.shapeAlaska);
    }

}
