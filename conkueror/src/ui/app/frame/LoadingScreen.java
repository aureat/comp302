package ui.app.frame;

import ui.app.Config;
import ui.assets.Assets;
import ui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class LoadingScreen extends JFrame {

    private final LoadingBackground backgroundPanel;
    private final LoadingSpinner spinner;

    public LoadingScreen() {

        // initialize dialog
        initDialog();

        // set background
        backgroundPanel = new LoadingBackground(getPreferredSize());
        backgroundPanel.setBounds(0, 0, getPreferredSize().width, getPreferredSize().height);
        add(backgroundPanel, BorderLayout.CENTER);

        // add spinner
        spinner = new LoadingSpinner(80);
        spinner.setBounds(
                (getWidth() - spinner.getPreferredSize().width) / 2,
                getHeight() - spinner.getPreferredSize().height - 100,
                spinner.getPreferredSize().width,
                spinner.getPreferredSize().height
        );
        spinner.setOpaque(false);
        backgroundPanel.add(spinner);

    }

    public void initDialog() {
        setLayout(new BorderLayout());
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setSize(new Dimension(Config.preferredWidth, Config.preferredHeight));
        setTitle(Config.windowTitle);
        setUndecorated(true);
    }

    public void stopAnimation() {
        setVisible(false);
        spinner.stop();
    }

    public void startAnimation() {
        setVisible(true);
        spinner.start();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(Config.preferredWidth, Config.preferredHeight);
    }

    private static class LoadingBackground extends JPanel {

        final Image bg;
        Dimension dimension;

        LoadingBackground(Dimension dimension) {
            this.bg = Assets.Background.getAsset("loading").getImage();
            this.dimension = dimension;
            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = SwingUtils.setQualityGraphics2D((Graphics2D) g.create());
            g2d.drawImage(bg, 0, 0, dimension.width, dimension.height, this);
            g2d.dispose();
        }

        @Override
        public Dimension getPreferredSize() {
            return dimension;
        }

    }

    private static class LoadingSpinner extends JPanel {

        private final int size;
        private final double ctrX;
        private final double ctrY;
        private final Image image;

        private double angle = 0;
        final long duration = 2000;
        final long startTime = System.currentTimeMillis();

        private final Timer timer;

        public LoadingSpinner(int size) {
            this.size = size;
            this.image = Assets.Animated.getAsset("spinner").getImage(size, size);
            this.ctrX = size / 2.0;
            this.ctrY = size / 2.0;
            setOpaque(false);
            setLayout(null);
            setSize(size, size);
            setMaximumSize(new Dimension(size, size));
            setDoubleBuffered(true);

            timer = new Timer(Config.animationDelay, e -> {
                long currentTime = System.currentTimeMillis();
                double t = ((currentTime - startTime) % duration) / (float) duration;
                angle = 2 * Math.PI * easeInOutQuad(t);
                repaint();
            });
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        public void start() {
            timer.start();
        }

        public void restart() {
            timer.restart();
        }

        public double easeInOutQuad(double x) {
            return x < 0.5 ? 2 * x * x : 1 - Math.pow(-2 * x + 2, 2) / 2;
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

}
