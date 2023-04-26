package app.menu;

import app.App;
import app.dialog.SystemActions;
import util.SystemInfo;
import util.SystemUtils;

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

    private App app;

    // Main Menu
    private JMenu mainMenu;
    private JMenuItem aboutMenuItem;
    private JMenuItem preferencesMenuItem;
    private JMenuItem quitMenuItem;

    // Game Controls Menu
    private JMenu gameMenu;
    private JMenuItem pauseResumeMenuItem;
    private JMenuItem newGameMenuItem;
    private JMenuItem saveExitMenuItem;
    private JMenuItem exitMenuItem;

    // Help Menu
    private JMenu helpMenu;
    private JMenuItem helpMenuItem;

    // Github
    private JMenu githubMenu;
    private JMenuItem githubMenuItem;

    public AppMenuBar(App app) {
        this.app = app;
        initMenus();
        setupMacOS();
    }

    private void initMenus() {
        {
            mainMenu = new JMenu("Main");
            {
                aboutMenuItem = new JMenuItem("About");
                aboutMenuItem.addActionListener(e -> app.getSystemActions().openAboutDialog());
                mainMenu.add(aboutMenuItem);
            }
            {
                preferencesMenuItem = new JMenuItem("Preferences");
                preferencesMenuItem.addActionListener(e -> app.getSystemActions().openPreferencesDialog());
                mainMenu.add(preferencesMenuItem);
            }
            {
                quitMenuItem = new JMenuItem("Quit App");
                quitMenuItem.addActionListener(e -> app.getSystemActions().quitApp());
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
                helpMenuItem.addActionListener(e -> app.getSystemActions().openHelpDialog());
                helpMenu.add(helpMenuItem);
            }
            add(helpMenu);
        }
        {
            githubMenu = new JMenu("Github");
            {
                githubMenuItem = new JMenuItem("Open Repository");
                githubMenuItem.addActionListener(e -> app.getSystemActions().openGithubLink());
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
                desktop.setAboutHandler(e -> app.getSystemActions().openAboutDialog());
            }
            if (desktop.isSupported(Desktop.Action.APP_PREFERENCES)) {
                preferencesMenuItem.setVisible(false);
                desktop.setPreferencesHandler(e -> app.getSystemActions().openPreferencesDialog());
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
