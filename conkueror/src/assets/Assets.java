package assets;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Toolkit.*;

public class Assets {

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
        return getImage(path).getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public static ImageIcon getImageIcon(String path) {
        return new ImageIcon(getImage(path));
    }

    public static ImageIcon getImageIcon(String path, int width, int height) {
        return new ImageIcon(getImage(path, width, height));
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
