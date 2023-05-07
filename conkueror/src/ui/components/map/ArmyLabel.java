package ui.components.map;

import ui.assets.Fonts;

import javax.swing.*;
import java.awt.*;

public class ArmyLabel extends JLabel {

        private int armyCount = 0;
        private Color color;

        public ArmyLabel() {
            setText(String.valueOf(armyCount));
            setFont(Fonts.GilroyExtraBold.deriveFont(25f));
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalTextPosition(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setSize(new Dimension(30, 30));
            setPreferredSize(new Dimension(30, 30));
            setForeground(Color.WHITE);
        }

        public void setArmyCount(int armyCount) {
            this.armyCount = armyCount;
            setText(String.valueOf(armyCount));
        }

        public void setColor(Color color) {
            this.color = color;
            repaint();
        }

        public int getArmyCount() {
            return armyCount;
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(color);
            g.fillOval(0, 0, 30, 30);
            super.paintComponent(g);
        }

}
