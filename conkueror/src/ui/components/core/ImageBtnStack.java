package ui.components.core;

import ui.assets.Asset;

import javax.swing.*;
import java.awt.*;

public class ImageBtnStack extends JPanel {

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private final int width, height, gap, arc;
    private final int direction;
    private int counter = 0;
    private final Dimension gapDimension;

    public ImageBtnStack(int direction, int width, int height, int gap, int arc) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        this.gap = gap;
        this.arc = arc;
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        if (direction == HORIZONTAL) {
            this.gapDimension = new Dimension(gap, height);
            setMinimumSize(new Dimension(0, height));
        } else {
            this.gapDimension = new Dimension(width, gap);
            setMinimumSize(new Dimension(width, 0));
        }
    }

    public ImageButton addButton(Asset asset) {
        counter++;
        ImageIcon imageIcon = asset.getImageIcon();
        ImageButton button = new ImageButton(imageIcon, arc, arc);
        add(button);
        add(Box.createRigidArea(gapDimension));
        if (direction == HORIZONTAL) {
            setMaximumSize(new Dimension(counter * (width + gap), height));
            setPreferredSize(new Dimension(counter * (width + gap), height));
        } else if (direction == VERTICAL) {
            setMaximumSize(new Dimension(width, counter * (height + gap)));
            setPreferredSize(new Dimension(width, counter * (height + gap)));
        }
        return button;
    }

}
