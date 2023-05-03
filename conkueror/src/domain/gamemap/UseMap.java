package domain.gamemap;

import java.lang.annotation.*;

/**
 * Registers game maps in the configuration.
 * Provides a name for the map.
 * @see GameMap
 * @since 0.4.1
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseMap {
    String name();
}
