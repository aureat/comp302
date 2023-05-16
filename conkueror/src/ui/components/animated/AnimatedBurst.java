package ui.components.animated;

import ui.app.Config;
import ui.assets.Assets;
import ui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class AnimatedBurst extends JPanel {

    public static final int LG = 750;
    public static final int MD = 500;
    public static final int SM = 250;

    private final int size;
    private final double ctrX;
    private final double ctrY;
    private final Image image;

    private double angle = 0;
    private double speed;

    public AnimatedBurst(int size, double speed) {
        this.size = size;
        this.image = Assets.Animated.getAsset("sunburst").getImage(size, size);
        this.ctrX = size / 2.0;
        this.ctrY = size / 2.0;
        setSpeed(speed);
        setOpaque(false);
        setLayout(null);
        setDoubleBuffered(true);
        new Timer(Config.animationDelay, e -> {
            angle += speed;
            repaint();
        }).start();
    }

    public AnimatedBurst(int size) {
        this(size, 0.008);
    }

    public void setSpeed(double speed) {
        this.speed = Math.toRadians(speed);
    }

    public void setSpeed(int speed) {
        setSpeed(speed / 10.0);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size, size);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = SwingUtils.setFastGraphics2D((Graphics2D) g.create());
        g2d.rotate(angle, ctrX, ctrY);
        g2d.drawImage(image, 0, 0, this);
        g2d.dispose();
    }

}
