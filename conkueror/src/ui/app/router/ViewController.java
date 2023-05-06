package ui.app.router;

public abstract class ViewController extends AbstractController implements RouterRedirect {

    private Route route;

    public ViewController() {
        super();
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public void update() {
        onUpdate();
        route.getView().updateView();
    }

    /**
     * Controller's initializer.
     */
    public abstract void initialize();

    /**
     * Hook for when a view is mounted.
     */
    public void onMount() {}

    /**
     * Hook for when the route is updated.
     */
    public void onUpdate() {}

}
