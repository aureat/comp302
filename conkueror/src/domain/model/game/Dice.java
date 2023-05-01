package domain.model.game;

import java.util.Random;

public class Dice {

    private static int sides = 6;

    public static int roll() {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

    public static int roll(int times) {
        int result = 0;
        for (int i = 0; i < times; i++) {
            result += roll();
        }
        return result;
    }

}
