package game;

import game.player.Player;

import java.util.Random;

public class Dice {

    private static int sides = 6;

    public static int roll() {
        Random rand = new Random();
        return rand.nextInt(sides) + 1;
    }

}
