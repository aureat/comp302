package view.views;

import game.Game;

import javax.swing.*;
import java.awt.*;

public class BuildFrame extends JFrame {

    public BuildFrame() {
        super("Configure Game");
        setSize(StartFrame.width, StartFrame.height);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        JLabel welcome = new JLabel("Configure Game");
        welcome.setSize(StartFrame.width, 200);
        welcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        topPanel.add(welcome);
        add(topPanel);
        setVisible(true);
    }

}
