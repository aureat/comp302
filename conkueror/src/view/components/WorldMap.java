package view.components;

import view.graphics.MapGraphics;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class WorldMap extends JFrame {

    public static final int width = 1360;
    public static final int height = 765;

    public class NorthAmericaOutline extends JPanel implements MouseListener {

        private Shape shape;
        private Color defaultColor = Color.BLUE;
        private Color hoverColor = Color.RED;
        private boolean isHovered = false;

        public NorthAmericaOutline() {
            this.shape = MapGraphics.createNorthAmericaOutline();
            this.addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (isHovered) {
                g2d.setColor(hoverColor);
            } else {
                g2d.setColor(defaultColor);
            }
            g2d.draw(shape);
            g2d.dispose();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // do nothing
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            isHovered = true;
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            isHovered = false;
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // do nothing
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // do nothing
        }

    }

    public WorldMap() {
        setLayout(new OverlayLayout(this));
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel northAmericaOutline = new NorthAmericaOutline();
        northAmericaOutline.setBounds(14, 54, 456, 447);
        add(northAmericaOutline);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
//        new WorldMap();
    }

}
