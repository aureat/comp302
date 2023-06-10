package domain.game;

import domain.game.config.GameConfig;

import java.util.Random;

public class Dice {

    private static final int sides = GameConfig.get().getDiceSides();

    public static int roll() {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

}
