package configs;

import app.App;
import app.router.View;
import configs.game.*;
import domain.model.game.GameConfig;
import ui.ViewPanel;

import javax.swing.*;
import java.awt.*;
import java.lang.annotation.Annotation;

/**
 * Contains all the configurations for the application.
 * Change {@code gameConfig} to change which game configuration to use.
 * @see App
 * @see GameConfig
 * @since 1.0.0
 */
public class AppCfg {

    public static GameConfig gameConfig = new DefaultCfg();

    public static final String appName = "ConKUeror";
    public static final String appVersion = "1.0.0";
    public static final String appDeveloper = "Nerd^5";

    public static final String windowTitle = appName;

    public static final String aboutTitle = appName;
    public static final String aboutDescription = "Thrilling multi-player strategy game experience.";
    public static final String aboutVersion = appName + " version " + appVersion;
    public static final String aboutCopyright = AppCfg.aboutVersion + ". Developed by "  + AppCfg.appDeveloper + ".";

    public static final int preferredWidth = 1366;
    public static final int preferredHeight = 768;
    public static final boolean isResizable = true;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int screenWidth = (int) screenSize.getWidth();
    public static int screenHeight = (int) screenSize.getHeight();

    public static final String defaultAppIcon = "icon/default.png";
    public static final String taskbarAppIcon = "icon/taskbar.png";
    public static final String aboutIcon = "icon/about.png";

    public static final String githubLink = "https://github.com/altunh/2023S_nerd5";

    public static final String RouterViewPackage = "ui.views";

}
