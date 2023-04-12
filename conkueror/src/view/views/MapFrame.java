package view.views;

import ui.map.MapGraphics;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class MapFrame extends JFrame {

    public static final int width = 1280;
    public static final int height = 720;

    public static class NorthAmerica extends JPanel {

        private static final Shape northAmericaOutline = MapGraphics.createNorthAmericaOutline();
        private static final Shape greenlandOutline = MapGraphics.createGreenlandOutline();
        private static final Stroke outlineStroke = new BasicStroke(20f);

        private boolean hoveringNorthAmericaOutline;
        private boolean hoveringGreenlandOutline;

        public NorthAmerica() {
            setLayout(new OverlayLayout(this));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent e) {
                    hoveringNorthAmericaOutline = false;
                    hoveringGreenlandOutline = false;
                    repaint();
                }
            });

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    Point point = e.getPoint();
                    hoveringNorthAmericaOutline = northAmericaOutline.contains(point);
                    hoveringGreenlandOutline = greenlandOutline.contains(point);
                    repaint();
                }
            });
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D)g;

            // Draw North America
            g2d.setStroke(outlineStroke);
            g2d.setColor(hoveringNorthAmericaOutline ? Color.BLUE : Color.BLACK);
            g2d.draw(northAmericaOutline);

            // Draw Greenland
            g2d.setStroke(outlineStroke);
            g2d.setColor(hoveringGreenlandOutline ? Color.BLUE : Color.BLACK);
            g2d.draw(greenlandOutline);
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new NorthAmerica());
        frame.pack();
        frame.setVisible(true);
    }

}
