package ui.app.frame;

import ui.app.Config;
import ui.assets.AssetLoader;
import util.SystemInfo;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppFrame extends JFrame {

    private AppMenuBar menuBar;
    private AppPopupMenu popupMenu;
    private final SystemActions systemActions;

    public AppFrame() {

        /*
         * Initialize application frame
         * Sets the frame title, icon, size, location, etc.
         */
        initFrame();
        systemActions = new SystemActions(this);

        /*
         * Create system menus.
         * Initializes and mounts the MenuBar and PopupMenu (MacOS only)
         */
        initMenuBar();
        initMacOSMenus();

    }

    public AppMenuBar getAppMenuBar() {
        return menuBar;
    }

    public AppPopupMenu getAppPopupMenu() {
        return popupMenu;
    }

    public SystemActions getSystemActions() {
        return systemActions;
    }

    public void initSize() {
        getContentPane().setSize(new Dimension(Config.preferredWidth, Config.preferredHeight));
        getContentPane().setPreferredSize(new Dimension(Config.preferredWidth, Config.preferredHeight));
        getContentPane().setMinimumSize(new Dimension(Config.preferredWidth, Config.preferredHeight));
    }

    public void initFrame() {
        getContentPane().setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(Config.isResizable);
        getContentPane().setLayout(new BorderLayout());
        initSize();
        initTitle();
        initIcon();
    }

    private void initTitle() {
        setTitle(Config.windowTitle);
        setName(Config.windowTitle);
        if (SystemInfo.isMacFullWindowContentSupported) {
            getRootPane().putClientProperty("apple.awt.transparentTitleBar", true);
        }
    }

    private void initIcon() {
        List<Image> icons = AssetLoader.getImages(Config.defaultAppIcon, 1024, 512, 256, 128, 64, 48, 32, 24, 16);
        setIconImages(icons);
        if (Taskbar.isTaskbarSupported()) {
            Taskbar.getTaskbar().setIconImage(AssetLoader.getImage(Config.taskbarAppIcon));
        }
    }

    private void initMenuBar() {
        menuBar = new AppMenuBar(this);
        setJMenuBar(menuBar);
    }

    private void initMacOSMenus() {
        if (Taskbar.isTaskbarSupported()) {
            popupMenu = new AppPopupMenu(this);
            Taskbar.getTaskbar().setMenu(popupMenu);
        }
    }

}
