package ui.assets;

import javax.swing.*;
import java.awt.*;

public class Asset {

    private final String fullPath;
    private final int width;
    private final int height;

    // image cache
    private ImageIcon icon;
    private Image image;

    public Asset(String path) {
        this(path, 0, 0);
    }

    public Asset(String path, int width, int height) {
        this.fullPath = path;
        this.width = width;
        this.height = height;
    }

    public String getFullPath() {
        return fullPath;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void load() {
        if (image == null) {
            reload();
        }
    }

    public void reload() {
        if (width == 0 || height == 0) {
            image = AssetLoader.getImage(fullPath);
        } else {
            icon = AssetLoader.getImageIcon(fullPath, width, height);
            image = icon.getImage();
        }
    }

    public Image getImage() {
        load();
        return image;
    }

    public ImageIcon getImageIcon() {
        load();
        if (icon == null) {
            icon = new ImageIcon(image);
        }
        return icon;
    }

}