package ui.app.router;

import ui.app.Context;
import ui.app.router.Route;
import ui.app.router.Router;
import ui.app.router.RouterRedirect;

public abstract class AbstractController implements RouterRedirect {

    public AbstractController() {}

    /**
     * Gets the current application router.
     * @return application router
     */
    public Router getRouter() {
        return Context.get().getRouter();
    }

    /**
     * Redirects the application to a specified route.
     * @param route route being redirected to
     * @param args arguments to the controller constructor
     */
    public void redirect(Route route, Object... args) {
        try {
            getRouter().redirect(route, args);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
