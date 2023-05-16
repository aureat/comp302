package ui.app.util;

import util.SystemInfo;

import java.awt.*;
import java.awt.desktop.QuitStrategy;
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

    public static boolean supportsHelpViewer() {
        return Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.APP_HELP_VIEWER);
    }

    public static void openHelpViewer() {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().openHelpViewer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean supportsOpenLink() {
        return Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE);
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

    public static void initializeMacOsQuitStrategy() {
        if (SystemInfo.isMacOS) {
            System.setProperty("apple.eawt.quitStrategy", QuitStrategy.CLOSE_ALL_WINDOWS.toString());
        }
    }

    public static void initializeSystemProperties(String appName) {
        System.setProperty("sun.java2d.dpiaware", "false");
        if (SystemInfo.isMacOS) {
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("apple.awt.application.appearance", "system");
            System.setProperty("apple.awt.application.name", appName);
            System.setProperty("apple.eawt.application.name", appName);
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", appName);
            System.setProperty("sun.java2d.uiScale.enabled", "true");
            System.setProperty("sun.java2d.uiScale", "2.0");
            System.setProperty("sun.java2d.metal", "true");
        }
        if (SystemInfo.isWindows) {
            System.setProperty("sun.java2d.opengl", "true");
            System.setProperty("sun.java2d.uiScale.enabled", "false");
            System.setProperty("sun.java2d.xrender", "true");
        }
    }

}
