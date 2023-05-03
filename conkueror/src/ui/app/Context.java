package ui.app;

import ui.app.router.AbstractController;
import ui.app.frame.AppController;
import ui.app.frame.AppFrame;
import ui.app.frame.SystemActions;
import ui.app.router.Route;
import ui.app.router.Router;

public class Context {

    private static class ContextContainer {
        private static final Context instance = new Context();
    }

    public static Context get() {
        return ContextContainer.instance;
    }

    private AppController appController;
    private Router router;

    public Context() {}

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public AppController getAppController() {
        return appController;
    }

    public AppFrame getAppFrame() {
        return appController.getAppFrame();
    }

    public SystemActions getSystemActions() {
        return appController.getAppFrame().getSystemActions();
    }

    public Router getRouter() {
        return router;
    }

    public Route getRoute() {
        return router.getCurrentRoute();
    }

    public AbstractController getController() {
        return router.getCurrentRoute().getController();
    }

    public AbstractController getController(Route route) {
        return route.getController();
    }

}
