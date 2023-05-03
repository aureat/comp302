package ui.app.frame;

import ui.app.App;
import ui.app.Config;
import ui.assets.AssetLoader;
import ui.util.SwingUtils;
import ui.app.util.SystemUtils;

import javax.swing.*;
import java.awt.*;

/**
 * Handles system actions such as About, Preferences, Help, etc.
 * @see App
 */
public class SystemActions {

    private final AppFrame appFrame;

    public SystemActions(AppFrame appFrame) {
        this.appFrame = appFrame;
    }

    public void openAboutDialog() {

        // Create panel
        JPanel panel = SwingUtils.createYBoxedPanel();

        // Add icon
        ImageIcon icon = AssetLoader.getImageIcon(Config.aboutIcon, 180, 180);
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(iconLabel);

        // Add info
        JLabel infoLabel;
        {
            infoLabel = new JLabel("" +
                    "<html><center>" +
                    "<h2><b>" + Config.aboutTitle + "</b></center></h2>" +
                    "<p><b>" + Config.aboutDescription + "</b></p><br>" +
                    "<p><i>" + Config.aboutCopyright + "</i></p>" +
                    "</center></html>"
            );
        }
        infoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(infoLabel);

        // Show dialog
        JOptionPane.showMessageDialog(appFrame, panel, "About", JOptionPane.PLAIN_MESSAGE);

    }

    public void openPreferencesDialog() {
        JOptionPane.showMessageDialog(appFrame, "Preferences", "Preferences", JOptionPane.PLAIN_MESSAGE);
    }

    public void openHelpDialog() {
        JOptionPane.showMessageDialog(appFrame, "Help", "Help", JOptionPane.PLAIN_MESSAGE);
    }

    public void openNotImplemented() {
        JOptionPane.showMessageDialog(appFrame, "Not Implemented yet :)", "Info", JOptionPane.PLAIN_MESSAGE);
    }

    public void openGithubLink() {
        SystemUtils.openLink(Config.githubLink);
    }

    public void quitApp() {
        appFrame.dispose();
        System.exit(0);
    }

}
