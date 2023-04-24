package app;

import app.dialog.SystemActions;
import app.menu.AppMenuBar;
import app.menu.AppPopupMenu;
import assets.Assets;
import configs.AppCfg;
import app.router.Router;
import domain.model.game.Game;
import util.SystemInfo;
import util.SystemUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class App extends JFrame {

    private Router router;
    private Game game;
    private SystemActions systemActions;

    public App() {
        Game.useConfig(AppCfg.gameConfig);
        game = Game.getInstance();
        router = new Router(this);
        systemActions = new SystemActions(this);
        initApp();
    }

    private void initApp() {
        initTitle();
        initIcon();
        initMenuBar();
        initMacOSMenus();
        initFrame();
    }

    private void initTitle() {
        setTitle(AppCfg.windowTitle);
        setName(AppCfg.windowTitle);
        if (SystemInfo.isMacFullWindowContentSupported) {
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
        }
    }

    private void initIcon() {
        List<Image> icons = Assets.getImages(AppCfg.defaultAppIcon, 1024, 512, 256, 128, 64, 48, 32, 24, 16);
        setIconImages(icons);
        if (Taskbar.isTaskbarSupported()) {
            Taskbar.getTaskbar().setIconImage(Assets.getImage(AppCfg.taskbarAppIcon));
        }
    }

    private void initMenuBar() {
        setJMenuBar(new AppMenuBar(this));
    }

    private void initMacOSMenus() {
        if (Taskbar.isTaskbarSupported()) {
            Taskbar.getTaskbar().setMenu(new AppPopupMenu(this));
        }
    }

    private void initFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(AppCfg.isResizable);
        setMinimumSize(new Dimension(AppCfg.preferredWidth, AppCfg.preferredHeight));
        setPreferredSize(new Dimension(AppCfg.preferredWidth, AppCfg.preferredHeight));
    }

    public SystemActions getSystemActions() {
        return systemActions;
    }

    public static void main(String... args) {

        // Set macOS specific properties
        if (SystemInfo.isMacOS) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.name", "ConKUeror");
            System.setProperty("apple.awt.application.appearance", "system");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", "ConKUeror");
        }

        // Set System Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Run App
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.pack();
            app.setLocationRelativeTo(null);
            app.setVisible(true);
        });

    }

}
