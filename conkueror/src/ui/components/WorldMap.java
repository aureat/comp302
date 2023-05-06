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
        setSize(1091, 701);
        setOpaque(false);
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

    public void drawOutline(Graphics g, Shape shape, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphics.continentStroke));
        g2d.translate(x, y);
        g2d.draw(shape);
    }

    public void drawTerritory(Graphics g, Shape shape, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphics.territoryStroke));
        g2d.translate(x, y);
        g2d.draw(shape);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        paintOutlines(g2d);
        g2d.dispose();
    }

    public void paintOutlines(Graphics2D g) {
        drawOutline(g, mapGraphics.shapeNorthAmericaOutline, 9, 41);
        drawOutline(g, mapGraphics.shapeGreenlandOutline, 272, 12);
        drawOutline(g, mapGraphics.shapeSouthAmericaOutline, 97, 320);
        drawOutline(g, mapGraphics.shapeBritainOutline, 349, 128);
        drawOutline(g, mapGraphics.shapeIcelandOutline, 392, 80);
        drawOutline(g, mapGraphics.shapeEuropeOutline, 372, 61);
        drawOutline(g, mapGraphics.shapeAsiaOutline, 534, 10);
        drawOutline(g, mapGraphics.shapeJapanOutline, 934, 140);
        drawOutline(g, mapGraphics.shapeAfricaOutline, 362, 301);
        drawOutline(g, mapGraphics.shapeMadagascarOutline, 629, 523);
        drawOutline(g, mapGraphics.shapeIndonesiaOutline, 775, 412);
        drawOutline(g, mapGraphics.shapeNewGuineaOutline, 939, 408);
        drawOutline(g, mapGraphics.shapeOceaniaOutline, 868, 497);
    }

}
