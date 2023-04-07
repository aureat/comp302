package game;

import java.util.List;
import java.util.Random;

public class Utils {

    public static <T> T randomChoice(T[] array) {
        return array[new Random().nextInt(array.length)];
    }

    public static <T> T randomChoice(List<T> list) {
        return list.get(new Random().nextInt(list.size()));
    }

}
