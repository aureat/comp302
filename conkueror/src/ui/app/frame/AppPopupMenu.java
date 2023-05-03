package ui.app.frame;

import ui.app.Config;

import java.awt.*;

/**
 * Application popup menu (MacOS only)
 * @see PopupMenu
 * @see SystemActions
 */
public class AppPopupMenu extends PopupMenu {

    private final AppFrame appFrame;

    public MenuItem menuAbout;

    public AppPopupMenu(AppFrame appFrame) {
        this.appFrame = appFrame;
        setLabel(Config.windowTitle);
        setName(Config.windowTitle);
        initMenuItems();
    }

    private void initMenuItems() {
        {
            menuAbout = new MenuItem("About");
            menuAbout.addActionListener(e -> appFrame.getSystemActions().openAboutDialog());
            add(menuAbout);
        }
    }

}
