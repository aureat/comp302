package game;

import game.player.Player;
import game.map.WorldMap;
import game.round.Phase;

import java.util.List;
import java.util.Random;

public class Game {

    private static Game instance;
    private static WorldMap map;

    private static List<Player> players;

    Player currentPlayer;
    Phase phase;

    public Game() {

    }

    public static void createInstance() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

    public static void main(String[] args) {

        createInstance();

    }

}
