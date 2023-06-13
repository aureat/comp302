package ui.app;

import ui.app.frame.AppController;
import ui.app.frame.AppFrame;
import ui.app.frame.LoadingScreen;
import ui.app.router.Router;
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

        /* Set system specific properties */
        SystemUtils.initializeSystemProperties(Config.appName);

        /* Set System Look and Feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create app controller */
        AppController appController = new AppController();

        /* Run application */
        SwingUtilities.invokeLater(() -> {

            /* Create a loader */
            appController.runPreloader();
            appController.createLoadScreen();
            appController.showLoadScreen();

            /* Load application in the background */
            (new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() {
                    appController.create();
                    appController.runApplicationLoader();
                    return null;
                }

                @Override
                protected void done() {
                    appController.hideLoadScreen();
                    appController.show();
                }
            }).execute();

        });

    }

}
