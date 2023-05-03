package domain.util;

import java.util.List;
import java.util.Random;

public class CoreUtils {

    public static <T> T chooseRandom(T[] array) {
        return array[new Random().nextInt(array.length)];
    }

    public static <T> T chooseRandom(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }

    public static Enum<?> chooseRandom(Enum<?> enumeration) {
        return chooseRandom(enumeration.getDeclaringClass().getEnumConstants());
    }

    public static String separateOnCapital(String string) {
        return String.join(" ", string.split("(?=\\p{Lu})"));
    }

    public static String separateOnCapital(Enum<?> enumeration) {
        return separateOnCapital(enumeration.toString());
    }

    public static String separateOnCapital(Class<?> clazz) {
        return separateOnCapital(clazz.getSimpleName());
    }

    public static String firstWord(String string) {
        return string.split(" ")[0];
    }

    public static boolean isEmpty( String string ) {
        return string == null || string.isEmpty();
    }

    public static String removeLeading( String string, String leading ) {
        return string.startsWith( leading )
                ? string.substring( leading.length() )
                : string;
    }

    public static String removeTrailing( String string, String trailing ) {
        return string.endsWith( trailing )
                ? string.substring( 0, string.length() - trailing.length() )
                : string;
    }

}
