package util;

import java.awt.*;
import java.net.URI;

public class SystemUtils {

    public static void setAboutHandler(Runnable handler) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.APP_ABOUT)) {
                return;
            }
            Desktop.getDesktop().setAboutHandler(e -> handler.run());
        }
    }

    public static void setPreferencesHandler(Runnable handler) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.APP_PREFERENCES)) {
                return;
            }
            Desktop.getDesktop().setPreferencesHandler(e -> handler.run());
        }
    }

    public static void setQuitHandler(Runnable handler) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (!desktop.isSupported(Desktop.Action.APP_QUIT_HANDLER)) {
                return;
            }
            Desktop.getDesktop().setQuitHandler((e, r) -> handler.run());
        }
    }

    public static void openLink(String url) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(URI.create(url));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
