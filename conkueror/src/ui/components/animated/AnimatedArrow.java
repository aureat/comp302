package ui.components.animated;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.Arrays;

public class AnimatedArrow extends JPanel {

    private int startX, startY, endX, endY;
    private int currentX, currentY;
    private double t = 0.0;

    private int stroke = 4;
    private Color strokeColor = Color.BLACK;
    private Color fillColor = Color.WHITE;

    public AnimatedArrow(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        currentX = startX;
        currentY = startY;

        int delay = 15; //milliseconds
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                animate();
            }
        };
        new Timer(delay, taskPerformer).start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int currentX = (int) (startX + (endX - startX) * easeOutCubic(t));
        int currentY = (int) (startY + (endY - startY) * easeOutCubic(t));
        Graphics2D g2 = (Graphics2D) g;
        Line2D line = new Line2D.Float(startX, startY, currentX, currentY);
        g2.setStroke(new BasicStroke(4));
        g2.setColor(fillColor);
        g2.fill(line);
        g2.setColor(strokeColor);
        g2.setStroke(new BasicStroke(2));
        g2.draw(line);

        // Draw arrowhead if line is long enough
        if (Math.hypot(currentX - startX, currentY - startY) > 5) {
            g2.fill(getArrowhead(startX, startY, currentX, currentY));
        }
    }

    public Polygon getArrowhead(int x1, int y1, int x2, int y2) {
        int arrowSize = 24;
        Polygon arrowHead = new Polygon();

        // calculate the angle of the line
        double theta = Math.atan2(y2 - y1, x2 - x1);

        // calculate the location of the arrow points
        double x, y;
        x = x2 - arrowSize * Math.cos(theta + Math.PI / 6);
        y = y2 - arrowSize * Math.sin(theta + Math.PI / 6);
        arrowHead.addPoint((int) x, (int) y);
        arrowHead.addPoint(x2, y2);
        x = x2 - arrowSize * Math.cos(theta - Math.PI / 6);
        y = y2 - arrowSize * Math.sin(theta - Math.PI / 6);
        arrowHead.addPoint((int) x, (int) y);

        return arrowHead;
    }

    private double easeOutCubic(double t) {
        return (--t) * t + 1;
    }

    public void animate() {
        if(t < 1.0) {
            t += 0.01;
        } else {
            t = 0.0;
        }
        repaint();
    }

    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
//        AnimatedArrow arrow = new AnimatedArrow(50, 100, 350, 100);
//        arrow.setSize(300, 50);
//        frame.add(arrow);
//        frame.setSize(400, 400);
//        frame.pack();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setVisible(true);

        JFrame frame = new JFrame();
        frame.setSize(1920, 1080);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GraphicsDevice graphics = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice();
        System.out.println(graphics.getDisplayMode());
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        Arrays.stream(graphics.getDisplayModes()).toList().forEach(System.out::println);
        System.out.println(graphics.getDefaultConfiguration().getBounds());
        graphics.setDisplayMode(new DisplayMode(2560, 1600, 32, 60));
        frame.setVisible(true);

    }
}

