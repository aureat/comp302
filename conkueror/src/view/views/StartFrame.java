package ui;

import game.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame {

    public static final int width = 1280;
    public static final int height = 720;

    public static void main(String[] args) {
        new StartFrame();
    }

    public StartFrame() {
        initializeStartFrame();
    }

    public void initializeStartFrame() {
        this.setTitle(Game.gameName);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(width, height);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        add(mainPanel);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        JLabel welcome = new JLabel(Game.gameName);
        welcome.setSize(width, 200);
        welcome.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        topPanel.add(welcome);
        mainPanel.add(topPanel);

        JPanel midPanel = new JPanel();
        midPanel.setLayout(new GridBagLayout());

        JButton button = new JButton("New Game");
        button.setBounds(0, 0, 200, 60);

        JButton button2 = new JButton("Load Game");
        button.setBounds(0, 0, 200, 60);

        JButton button3 = new JButton("Exit");
        button.setBounds(0, 0, 200, 60);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuildFrame();
                dispose();
            }
        });

        midPanel.add(button);
        midPanel.add(button2);
        midPanel.add(button3);
        mainPanel.add(midPanel);

        this.setVisible(true);
    }

}
