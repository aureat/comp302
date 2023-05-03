package ui.app.frame;

import ui.app.Context;
import ui.app.router.AbstractController;
import ui.app.router.Router;
import ui.assets.Fonts;


public class AppController extends AbstractController {

    private AppFrame appFrame;
    private Router router;

    public AppController() {
        super();
    }

    public AppFrame getAppFrame() {
        return appFrame;
    }

    public void create() {
        if (appFrame != null) {
            return;
        }

        /* Register fonts */
        Fonts.register();

        /* Create the app frame and router */
        appFrame = new AppFrame();
        router = new Router();

        /* Create context */
        Context context = Context.get();
        context.setAppController(this);
        context.setRouter(router);

        /* Initialize the router */
        router.setContainer(appFrame.getContentPane());
        router.initRouter();

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
