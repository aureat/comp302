package util;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Set;

public class ClassUtils {

    public static Reflections getReflections(String prefix) {
        return new Reflections(prefix);
    }

    public static Reflections getReflections() {
        return getReflections("");
    }

    public static Set<Class<?>> getAnnotatedTypes(String prefix, Class<? extends Annotation> annotation) {
        return getReflections(prefix).getTypesAnnotatedWith(annotation);
    }

    public static Set<Class<?>> getAnnotatedTypes(Class<? extends Annotation> annotation) {
        return getAnnotatedTypes("", annotation);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(String prefix, Class<T> type) {
        return getReflections(prefix).getSubTypesOf(type);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(Class<T> type) {
        return getSubTypes("", type);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(
            String prefix,
            Class<T> type,
            Class<? extends Annotation> annotation
    ) {
        Set<Class<? extends T>> subTypes = getSubTypes(prefix, type);
        subTypes.removeIf(subType -> !subType.isAnnotationPresent(annotation));
        return subTypes;
    }

    public static <T> Set<Class<? extends T>> getSubTypes(Class<T> type, Class<? extends Annotation> annotation) {
        return getSubTypes("", type, annotation);
    }

    public static <T> T newInstance(Class<T> type, Object... args) throws NoSuchMethodException, RuntimeException {

        // Get classes of objects
        Class<?>[] argTypes = Arrays.stream(args).map(arg -> {
            if (arg == null)
                return Object.class;
            return arg.getClass();
        }).toArray(Class<?>[]::new);

        // Get constructor
        try {
            return type.getDeclaredConstructor(argTypes).newInstance(args);
        } catch (NoSuchMethodException e) {
            throw new NoSuchMethodException("No constructor found for " +
                    type.getName() +
                    " with arguments " +
                    Arrays.toString(argTypes) +
                    ".");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends Annotation> T getModuleAnnotation(Class<T> annotation) {
        return ClassUtils.class.getModule().getAnnotation(annotation);
    }

}
