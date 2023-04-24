package ui.views;

import ui.components.WorldMap;
import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;

public class StartFrame extends JFrame {

    public static final int width = 1600;
    public static final int height = 900;

    public static void main(String[] args) {
        new StartFrame();
    }

    public StartFrame() {
        initFrame();
    }

    public void initFrame() {

        setTitle("ConKUeror");
        setSize(width, height);
        setPreferredSize(new Dimension(width, height));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        MapGraphics mapGraphics = MapGraphics.getInstance();
        WorldMap map = new WorldMap();
        map.setBounds(166, 16, 1534, 985);

        getContentPane().add(map);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

}
