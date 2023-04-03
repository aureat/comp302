package game;

import java.util.Random;

public class Utils {

    public static <T> T randomChoice(T[] array) {
        return array[new Random().nextInt(array.length)];
    }

}
