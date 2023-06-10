package ui.app;

import util.ModuleInfo;

import java.awt.*;

/**
 * Contains all the configurations for the application.
 * Change {@code gameConfig} to change which game configuration to use.
 * @see App
 * @since 0.3.0
 */
public class Config {

    public static final String appName = "ConKUeror";
    public static final String appVersion = ModuleInfo.version;
    public static final String appDeveloper = ModuleInfo.developer;

    public static final String windowTitle = appName;

    public static final String aboutTitle = appName;
    public static final String aboutDescription = "Thrilling multi-player strategy game experience.";
    public static final String aboutVersion = appName + " version " + appVersion;
    public static final String aboutCopyright = aboutVersion + ". Developed by "  + appDeveloper + ".";

    public static final int preferredWidth = 1366;
    public static final int preferredHeight = 768;
    public static final boolean isResizable = true;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int screenWidth = (int) screenSize.getWidth();
    public static int screenHeight = (int) screenSize.getHeight();

    public static int animationDelay = 1000 / 60;

    public static final String defaultAppIcon = "icon/default.png";
    public static final String taskbarAppIcon = "icon/taskbar.png";
    public static final String aboutIcon = "icon/about.png";

    public static final String githubLink = "https://github.com/altunh/2023S_nerd5";

}
