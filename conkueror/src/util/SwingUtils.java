package util;

import java.awt.*;

/**
 * Utility methods for Swing.
 * @since 1.0.0
 */
public class SwingUtils {

    /**
     * Search for a (grand) child component with the given name.
     *
     * @return a component; or {@code null}
     */
    @SuppressWarnings( "unchecked" )
    public static <T extends Component> T getComponentByName(Container parent, String name ) {
        for (Component child : parent.getComponents()) {
            if (name.equals(child.getName()))
                return (T) child;
            if (child instanceof Container) {
                T c = getComponentByName((Container) child, name);
                if (c != null)
                    return c;
            }
        }
        return null;
    }

}
