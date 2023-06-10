package util.annotations;

import java.lang.annotation.*;

/**
 * Describes the developer of the module.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.MODULE)
public @interface Developer {
    String value();
}
