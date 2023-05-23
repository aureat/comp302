package ui.app.frame;

import ui.app.Context;
import ui.app.router.AbstractController;
import ui.app.router.Router;
import ui.assets.Assets;
import ui.assets.Fonts;


public class AppController {

    private LoadingScreen loadingScreen;
    private AppFrame appFrame;
    private Router router;

    public AppController() {}

    public AppFrame getAppFrame() {
        return appFrame;
    }

    public AppFrame create() {
        if (appFrame == null)
            appFrame = new AppFrame();
        return appFrame;
    }

    public void runPreloader() {
        Fonts.register();
        Assets.Background.loadAsset("loading");
        Assets.Animated.loadAsset("spinner");
    }

    public LoadingScreen createLoadScreen() {
        if (loadingScreen == null)
            loadingScreen = new LoadingScreen();
        return loadingScreen;
    }

    public void showLoadScreen() {
        loadingScreen.pack();
        loadingScreen.setLocationRelativeTo(null);
        loadingScreen.setVisible(true);
        loadingScreen.startAnimation();
    }

    public void hideLoadScreen() {
        loadingScreen.setVisible(false);
        loadingScreen.stopAnimation();
    }

    public void runApplicationLoader() {
        /* Create the router */
        router = new Router();

        /* Create context */
        Context context = Context.get();
        context.setAppController(this);
        context.setRouter(router);

        /* Initialize the router */
        router.setContainer(appFrame.getContentPane());
        router.initRouter();

        /* Show default view */
        routeDefault();
    }

    public void show() {
        appFrame.pack();
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);
    }

    public void routeDefault() {
        router.mountNewDefaultView();
    }

    public void hide() {
        appFrame.setVisible(false);
    }

    public void close() {
        appFrame.setVisible(false);
        appFrame.dispose();
        appFrame = null;
    }

}
