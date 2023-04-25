package util;

import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;

public class ClassUtils {

    public static Set<Class<?>> getAnnotatedTypes(String prefix, Class<? extends Annotation> annotation) {
        return new Reflections(prefix).getTypesAnnotatedWith(annotation);
    }

    public static Set<Class<?>> getAnnotatedTypes(Class<? extends Annotation> annotation) {
        return getAnnotatedTypes("", annotation);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(String prefix, Class<T> type) {
        return new Reflections(prefix).getSubTypesOf(type);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(Class<T> type) {
        return getSubTypes("", type);
    }

    public static <T> Set<Class<? extends T>> getSubTypes(String prefix, Class<T> type, Class<? extends Annotation> annotation) {
        Set<Class<? extends T>> subTypes = getSubTypes(prefix, type);
        subTypes.removeIf(subType -> !subType.isAnnotationPresent(annotation));
        return subTypes;
    }

    public static <T> Set<Class<? extends T>> getSubTypes(Class<T> type, Class<? extends Annotation> annotation) {
        return getSubTypes("", type, annotation);
    }

    public static <T> T newInstance(Class<T> type, Object... args) throws RuntimeException {
        try {
            Class<?>[] argTypes = new Class<?>[args.length];
            Arrays.stream(argTypes).map(Object::getClass).toArray();
            Constructor<T> constructor = type.getDeclaredConstructor(argTypes);
            if (constructor == null) {
                throw new RuntimeException("No constructor found for " + type.getName());
            }
            return constructor.newInstance(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
