package app.router;

/**
 * Interface for redirecting to a view.
 * All view panels must implement this interface.
 * @see Router
 */
public interface RouterRedirect {
    Router getRouter();
    void setRouter(Router router);
    void redirect(String name, Object... args);
}
