package model.game;

import model.map.WorldMap;
import model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final String gameName = "ConKUeror";
    private int infantryPerPlayer ;
    private int cavalryPerPlayer;
    private int artilleryPerPlayer;

    private static Game instance;

    private Game() {
        // Constructor logic here
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public int getPlayerCount(){
        return 0; // Should be related to the phase building
    }
    public int getArtilleryPerPlayer(){
        return cavalryPerPlayer;
    }
    public int getCavalryPerPlayer(){
        return artilleryPerPlayer;
    }
    public int getInfantryPerPlayer(){
        return infantryPerPlayer;
    }



}
