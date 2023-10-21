package ui.app.frame;

import ui.app.Config;
import ui.assets.AssetLoader;
import util.SystemInfo;

import javax.swing.*;
import javax.swing.plaf.MenuBarUI;
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
//        initPopupMenu();
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
        if (Taskbar.getTaskbar().isSupported(Taskbar.Feature.ICON_IMAGE)) {
            Taskbar.getTaskbar().setIconImage(AssetLoader.getImage(Config.taskbarAppIcon));
        }
    }

    private void initMenuBar() {
        if (SystemInfo.isMacOS) {
//            menuBar = new AppMenuBar(this);
//            var menuBar = new MenuBar();
//            menuBar.add(new Menu("Test Menu"));
//            Desktop.getDesktop().setDefaultMenuBar(menuBar);
//            setMenuBar(menuBar);
            var menuBar = new MenuBar();
            setMenuBar(menuBar);
            menuBar = getMenuBar();
            System.out.println(menuBar.getMenu(0));
//            menuBar.add(new Menu("Test Menu"));
        }
    }

    private void initPopupMenu() {
        if (Taskbar.getTaskbar().isSupported(Taskbar.Feature.MENU)) {
            popupMenu = new AppPopupMenu(this);
            Taskbar.getTaskbar().setMenu(popupMenu);
        }
    }

}
