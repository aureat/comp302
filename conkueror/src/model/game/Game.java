package model.game;

import game.player.Player;
import game.map.WorldMap;
import game.round.Phase;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final String gameName = "ConKUeror";

    private static Game instance;

    private WorldMap map;
    private List<Player> players;

    Player currentPlayer;
    Phase phase;

    public Game() {
        this.players = new ArrayList<>();
        this.map = new WorldMap();
    }

    public int getPlayerCount() {
        return players.size();
    }

    public static void createInstance() {
        instance = new Game();
    }

    public static Game getInstance() {
        return instance;
    }

//    public static void main(String[] args) {
//
//        createInstance();
//
//    }

}
