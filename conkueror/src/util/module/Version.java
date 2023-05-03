package util.module;

import java.lang.annotation.*;

/**
 * Describes the version of the module.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.MODULE)
public @interface Version {
    String value();
}
