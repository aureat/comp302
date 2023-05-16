package ui.app;

import ui.app.frame.AppController;
import ui.app.util.SystemUtils;

import javax.swing.*;

/**
 * Entry point of the application.
 * Where the app is created and started.
 *
 * @see AppController
 *
 * @since 0.4.0
 */
public class App {

    public static void main(String... args) {

        /* Set macOS specific properties */
        SystemUtils.initializeMacOsProperties(Config.appName);

        /* Enable OpenGL acceleration */
//        System.setProperty("sun.java2d.opengl", "true");
        System.setProperty("sun.java2d.metal", "true");
        System.setProperty("sun.java2d.uiScale.enabled", "true");
        System.setProperty("sun.java2d.uiScale", "2.0");
        System.setProperty("sun.java2d.dpiaware", "false");
        System.setProperty("sun.java2d.xrender", "true");

        /* Set System Look and Feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create app frame */
        AppController appController = new AppController();

        SwingUtilities.invokeLater(() -> {
            /* Create app components */
            appController.create();
            /* Show default view */
            appController.routeDefault();
            /* Show app frame */
            appController.show();
        });

    }

}
