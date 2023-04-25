package app.router;

import java.lang.annotation.*;


/**
 * Annotates view panels to be included in the router.
 * String names are used to reference views through the router.
 * <ul>
 *      <li>Set {@code isDefault=true} to set it as the home view.</li>
 *      <li>Set {@code cacheable=true} for the view to be cached whenever possible.</li>
 * </ul>
 * @see ui.ViewPanel
 * @see RouterRedirect
 * @see Router
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface View {
    String name();
    boolean isDefault() default false;
    boolean cacheable() default true;
}
