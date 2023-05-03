package ui.app.frame;

import util.SystemInfo;
import ui.app.util.SystemUtils;
import ui.app.App;

import javax.swing.*;
import java.awt.*;

/**
 * The application menu bar.
 * Modifies the menu bar based on the operating system.
 * @see JMenuBar
 * @see App
 * @see SystemInfo
 * @see SystemUtils
 * @see SystemActions
 */
public class AppMenuBar extends JMenuBar {

    private final AppFrame appFrame;

    // Main Menu
    public JMenu mainMenu;
    public JMenuItem aboutMenuItem;
    public JMenuItem preferencesMenuItem;
    public JMenuItem quitMenuItem;

    // Game Controls Menu
    public JMenu gameMenu;
    public JMenuItem pauseResumeMenuItem;
    public JMenuItem newGameMenuItem;
    public JMenuItem saveExitMenuItem;
    public JMenuItem exitMenuItem;

    // Help Menu
    public JMenu helpMenu;
    public JMenuItem helpMenuItem;

    // Github
    public JMenu githubMenu;
    public JMenuItem githubMenuItem;

    public AppMenuBar(AppFrame appFrame) {
        this.appFrame = appFrame;
        initMenus();
        setupMacOS();
    }

    private void initMenus() {
        {
            mainMenu = new JMenu("Main");
            {
                aboutMenuItem = new JMenuItem("About");
                aboutMenuItem.addActionListener(e -> appFrame.getSystemActions().openAboutDialog());
                mainMenu.add(aboutMenuItem);
            }
            {
                preferencesMenuItem = new JMenuItem("Preferences");
                preferencesMenuItem.addActionListener(e -> appFrame.getSystemActions().openPreferencesDialog());
                mainMenu.add(preferencesMenuItem);
            }
            {
                quitMenuItem = new JMenuItem("Quit App");
                quitMenuItem.addActionListener(e -> appFrame.getSystemActions().quitApp());
                mainMenu.add(quitMenuItem);
            }
            add(mainMenu);
        }
        {
            gameMenu = new JMenu("Game");
            {
                pauseResumeMenuItem = new JMenuItem("Pause/Resume");
                gameMenu.add(pauseResumeMenuItem);
            }
            {
                newGameMenuItem = new JMenuItem("New Game");
                gameMenu.add(newGameMenuItem);
            }
            {
                saveExitMenuItem = new JMenuItem("Save & Exit");
                gameMenu.add(saveExitMenuItem);
            }
            {
                exitMenuItem = new JMenuItem("Exit to Login");
                gameMenu.add(exitMenuItem);
            }
            add(gameMenu);
        }
        {
            helpMenu = new JMenu("Help");
            {
                helpMenuItem = new JMenuItem("Show Help");
                helpMenuItem.addActionListener(e -> appFrame.getSystemActions().openHelpDialog());
                helpMenu.add(helpMenuItem);
            }
            add(helpMenu);
        }
        {
            githubMenu = new JMenu("Github");
            {
                githubMenuItem = new JMenuItem("Open Repository");
                githubMenuItem.addActionListener(e -> appFrame.getSystemActions().openGithubLink());
                githubMenu.add(githubMenuItem);
            }
            add(githubMenu);
        }
    }

    private void setupMacOS() {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.APP_ABOUT)) {
                aboutMenuItem.setVisible(false);
                desktop.setAboutHandler(e -> appFrame.getSystemActions().openAboutDialog());
            }
            if (desktop.isSupported(Desktop.Action.APP_PREFERENCES)) {
                preferencesMenuItem.setVisible(false);
                desktop.setPreferencesHandler(e -> appFrame.getSystemActions().openPreferencesDialog());
            }
            if (desktop.isSupported(Desktop.Action.APP_QUIT_HANDLER)) {
                quitMenuItem.setVisible(false);
                desktop.setQuitHandler((e, response) -> response.performQuit());
            }
        }
        if (SystemInfo.isMacOS) {
            mainMenu.setVisible(false);
        }
    }

}
