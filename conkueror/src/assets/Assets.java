package assets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Toolkit.*;

/**
 * Contains all the assets used in the application.
 * @since 1.0.0
 */
public class Assets {

    public static int scaleHints = Image.SCALE_SMOOTH;

    public enum Background {
        Loading("loading.png"),
        Main("main.png"),
        Login("login.png"),
        Map("map.png"),
        Sunburst("sunburst.png"),
        SunburstLogoMd("sunburst-logo-md.png"),
        SunburstLogoSm("sunburst-logo-sm.png");

        private final String path;
        private final Image image;

        private static final String base = "backgrounds/";

        Background(String path) {
            this.path = path;
            this.image = Assets.getImage(base + path);
        }

        public ImageIcon getImageIcon() {
            return Assets.getImageIcon(image);
        }

        public ImageIcon getImageIcon(int width, int height) {
            return Assets.getImageIcon(image, width, height);
        }
    }

    public static void setScaleHints(int scaleHints) {
        Assets.scaleHints = scaleHints;
    }

    public static URL getURL(String path) {
        return Assets.class.getResource("/" + path);
    }

    public static URL getImageURL(String path) {
        return getURL("images/" + path);
    }

    public static Image getImage(String path) {
        return getDefaultToolkit().getImage(getImageURL(path));
    }

    public static Image getImage(String path, int width, int height) {
        return scaleImage(getImage(path), width, height);
    }

    public static Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, scaleHints);
    }

    public static ImageIcon getImageIcon(String path) {
        return new ImageIcon(getImage(path));
    }

    public static ImageIcon getImageIcon(Image image) {
        return new ImageIcon(image);
    }

    public static ImageIcon getImageIcon(String path, int width, int height) {
        return getImageIcon(getImage(path, width, height));
    }

    public static ImageIcon getImageIcon(Image image, int width, int height) {
        return new ImageIcon(scaleImage(image, width, height));
    }

    public static java.util.List<Image> getImages(String path, int... sizes) {
        List<Image> images = new ArrayList<>();
        for (int size : sizes) {
            images.add(getImage(path, size, size));
        }
        return images;
    }

    public static java.util.List<ImageIcon> getImageIcons(String path, int... sizes) {
        List<ImageIcon> images = new ArrayList<>();
        for (int size : sizes) {
            images.add(getImageIcon(path, size, size));
        }
        return images;
    }

}
