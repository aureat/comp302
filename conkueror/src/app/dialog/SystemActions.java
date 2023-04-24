package app.dialog;

import app.App;
import assets.Assets;
import configs.AppCfg;
import util.SystemUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SystemActions {

    private App app;

    public SystemActions(App app) {
        this.app = app;
    }

    public void openAboutDialog() {

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Add icon
        ImageIcon icon = Assets.getImageIcon(AppCfg.aboutIcon, 180, 180);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(iconLabel);

        // Add info
        JLabel infoLabel;
        {
            infoLabel = new JLabel("" +
                    "<html><center>" +
                    "<h2><b>" + AppCfg.aboutTitle + "</b></center></h2>" +
                    "<p><b>" + AppCfg.aboutDescription + "</b></p><br>" +
                    "<p><i>" + AppCfg.aboutCopyright + "</i></p>" +
                    "</center></html>"
            );
        }
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(infoLabel);

        // Show dialog
        JOptionPane.showMessageDialog(app, panel, "About", JOptionPane.PLAIN_MESSAGE);

    }

    public void openPreferencesDialog() {
        JOptionPane.showMessageDialog(app, "Preferences", "Preferences", JOptionPane.PLAIN_MESSAGE);
    }

    public void openHelpDialog() {
        JOptionPane.showMessageDialog(app, "Help", "Help", JOptionPane.PLAIN_MESSAGE);
    }

    public void openGithubLink() {
        SystemUtils.openLink(AppCfg.githubLink);
    }

    public void quitApp() {
        app.dispose();
        System.exit(0);
    }

}
