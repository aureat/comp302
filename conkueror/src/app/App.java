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

/**
 * Entry point of the application.
 * Where the router and game are initialized.
 * @see JFrame
 * @see AppCfg
 * @see Router
 * @see SystemActions
 * @see Game
 */
public class App extends JFrame {

    private final Router router;
    private final SystemActions systemActions;

    private final Game game = Game.getInstance();

    public App() {
        /*
         * Initialize application frame
         * Sets the frame title, icon, size, location, etc.
         */
        initFrame();

        /*
         * Specify game configuration.
         * Initialize System Actions
         */
        Game.useConfig(AppCfg.gameConfig);
        systemActions = new SystemActions(this);

        /*
         * Create and configure the router.
         * Scans all types annotated with @View and registers them to the router.
         * Sets the container of the router to the content pane of the frame.
         */
        router = new Router(this);
        router.setContainer(getContentPane());

        /*
         * Create system menus.
         * Initializes and mounts the MenuBar and PopupMenu (MacOS only)
         */
        initMenuBar();
        initMacOSMenus();

        /* Mount the default view */
        router.mountNewDefaultView();
    }

    public Router getRouter() {
        return router;
    }

    public SystemActions getSystemActions() {
        return systemActions;
    }

    public Game getGame() {
        return game;
    }

    private void initFrame() {
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(AppCfg.isResizable);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setSize(new Dimension(AppCfg.preferredWidth, AppCfg.preferredHeight));
        getContentPane().setMinimumSize(new Dimension(AppCfg.preferredWidth, AppCfg.preferredHeight));
        getContentPane().setPreferredSize(new Dimension(AppCfg.preferredWidth, AppCfg.preferredHeight));
        initTitle();
        initIcon();
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

    public static void main(String... args) {

        // Set macOS specific properties
        SystemUtils.initializeMacOsProperties(AppCfg.appName);

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
