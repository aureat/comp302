package ui.assets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Toolkit.*;

/**
 * Contains methods for loading assets.
 * @since 0.4.0
 */
public class AssetLoader {

    /**
     * The default scale hints for scaling images.
     */
    public static int scaleHints = Image.SCALE_SMOOTH;

    /**
     * Sets the default scale hints for scaling images.
     * @param hints java.awt.Image scaling hints
     */
    public static void setScaleHints(int hints) {
        scaleHints = hints;
    }

    /**
     * Gets the URL of the asset.
     */
    public static URL getURL(String path) {
        return AssetLoader.class.getResource("/" + path);
    }

    /**
     * Gets the image URL of the asset.
     */
    public static URL getImageURL(String imagePath) {
        return getURL("images/" + imagePath);
    }

    /**
     * Returns a new Image object from the given image path.
     * @param imagePath path to image
     * @return Image
     */
    public static Image getImage(String imagePath) {
        return getDefaultToolkit().getImage(getImageURL(imagePath));
    }

    /**
     * Returns a new Image object from the given image path with the given width and height.
     * @return scaled java.awt.Image
     */
    public static Image scaleImage(Image image, int width, int height) {
        return image.getScaledInstance(width, height, scaleHints);
    }

    /**
     * Returns the source image from ImageIcon scaled to the given width and height.
     * @return Image from ImageIcon
     */
    public static Image getImage(String imagePath, int width, int height) {
        return new ImageIcon(scaleImage(getImage(imagePath), width, height)).getImage();
    }

    public static Image getImage(Image image, int width, int height) {
        return new ImageIcon(scaleImage(image, width, height)).getImage();
    }

    public static ImageIcon getImageIcon(String imagePath) {
        return new ImageIcon(getImageURL(imagePath));
    }

    public static ImageIcon getImageIcon(Image image) {
        return new ImageIcon(image);
    }

    public static ImageIcon getImageIcon(String imagePath, int width, int height) {
        return getImageIcon(getImage(imagePath, width, height));
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
