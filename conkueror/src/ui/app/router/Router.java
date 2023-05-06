package ui.app.router;

import util.module.ModuleInfo;
import util.ClassUtils;

import java.awt.*;
import java.util.*;

/**
 * Manages the routes for the application and handles route redirection.
 * Scans for and registers views and controllers.
 * @since 0.4.0
 */
public class Router {

    // containers
    private Container container;

    // tracking routes
    private Route defaultRoute;
    private Route currentRoute;

    public Router() {}

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Route getCurrentRoute() {
        return currentRoute;
    }

    public void setCurrentRoute(Route currentRoute) {
        this.currentRoute = currentRoute;
    }

    public void initRouter() {
        try {
            setupRouter();
            registerRoutes();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void setupRouter() {

    }

    public void registerRoutes() throws RouterConfigException {
        // get all routes
        Route[] routes = Route.values();
        for (Route route : routes) {
            if (route.isDefault()) {
                if (defaultRoute != null) {
                    throw new RouterConfigException("Multiple default routes found");
                }
                defaultRoute = route;
            }
        }
        // if default route not found, throw an exception
        if (defaultRoute == null) {
            throw new RouterConfigException("Default route not found");
        }
        registerViewPanels();
    }

    public void redirect(Route route, Object... args) throws IllegalRouteException {
        System.out.println("Redirecting to " + route);
        route.setRoute(this, args);
    }

    public void mountNewDefaultView() {
        defaultRoute.setRoute(this);
    }

    public void replaceContainer(ViewPanel<? extends ViewController> view) {
        container.removeAll();
        container.add(view);
        container.revalidate();
        container.repaint();
    }

    /**
     * Exception for illegal routes.
     * @since 0.4.0
     */
    public static class IllegalRouteException extends Exception{

        public IllegalRouteException(String message){
            super(message);
        }

        @Override
        public String toString() {
            return "IllegalRouteException: " + getMessage();
        }

    }

    /**
     * Exception for router configuration errors.
     * @since 0.4.0
     */
    public static class RouterConfigException extends Exception{

        public RouterConfigException(String message){
            super(message);
        }

        @Override
        public String toString() {
            return "RouterConfigException: " + getMessage();
        }

    }

    /**
     * Scans for view types and registers them.
     */
    public void registerViewPanels() {
        try {
            Set<Class<? extends ViewPanel<? extends ViewController>>> types =
                    ClassUtils.getReflections(ModuleInfo.RouterViewsPackage)
                            .getSubTypesOf((Class<ViewPanel<? extends ViewController>>) (Class<?>) ViewPanel.class);
            types.removeIf(type -> !type.isAnnotationPresent(View.class));
            types.forEach(type -> {
                View viewAnnotation = type.getAnnotation(View.class);
                Route route = viewAnnotation.at();
                route.setViewType(type);
                ViewPanel view = route.createView();
                view.setSize(container.getSize());
            });
            Set<Class<? extends ViewController>> controllerTypes =
                    ClassUtils.getReflections(ModuleInfo.RouterControllersPackage)
                            .getSubTypesOf(ViewController.class);
            controllerTypes.forEach(type -> {
                Controller controllerAnnotation = type.getAnnotation(Controller.class);
                Route route = controllerAnnotation.at();
                route.setControllerType((Class<ViewController>) type);
                route.createController();
                route.preloadView();
            });
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
