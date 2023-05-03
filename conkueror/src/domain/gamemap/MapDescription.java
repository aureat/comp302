package domain.gamemap;

import java.lang.annotation.*;

/**
 * Used to add descriptions to a GameMap.
 * @see GameMap
 * @since 0.4.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface MapDescription {
    String value();
}
