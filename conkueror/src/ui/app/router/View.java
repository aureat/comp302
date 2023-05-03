package ui.app.router;

import ui.app.router.Route;
import ui.app.router.Router;

import java.lang.annotation.*;

/**
 * Registers a view class to the router.
 * Use {@link Route} to specify the route for the view.
 *
 * @since 0.4.0
 * @see Router
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface View {
    Route at();
}
