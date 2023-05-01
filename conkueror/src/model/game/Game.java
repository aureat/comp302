package model.game;

import domain.model.map.GameMap;
import domain.model.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final String gameName = "ConKUeror";
    private int infantryPerPlayer ;
    private int cavalryPerPlayer;
    private int artilleryPerPlayer;

    private ArrayList<Player> playerArrayList;

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












    public void newGame(){
        playerArrayList = new ArrayList<>();
        // Adding AI to the game
        Player computer = new Player();
        computer.setComputer(true);
        playerArrayList.add(computer);
        // Adding first player into the game
        playerArrayList.add(new Player());
    }








}
