package ui.app.router;

/**
 * Interface for classes that can redirect to routes.
 * @since 0.4.0
 * @see Controller
 * @see View
 * @see Router
 */
public interface RouterRedirect {
    Router getRouter();
    void redirect(Route route, Object... args);
}
