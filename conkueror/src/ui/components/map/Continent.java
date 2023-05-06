package ui.components.map;

import javax.swing.*;
import java.awt.*;

public class Continent extends JComponent {

    private Shape shape;

    public Continent(Shape shape) {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }

}
