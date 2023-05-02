package domain.model.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import domain.model.card.ChanceCard;
import domain.model.map.GameMap;
import domain.model.player.Player;

public class Game {

    private static GameConfig config;

    private Phase phase;
    private Player currentplayer;
    private GameMap map;

    private int roundCount = -1;

    private ArrayList<Player> players = new ArrayList<>();
    private int playerCount;
    private ChanceCard currentcard;

    private static class GameContainer {
        private static Game instance;
    }

    public static Game getInstance() {
        return GameContainer.instance;
    }

    private Game() {
        this.players.add(new Player());
        this.players.add(new Player());
    }

    public void addPlayer() {
        players.add(new Player());
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static void useConfig(GameConfig config) {
        Game.config = config;
    }

    public int getPlayerCount() {
        return players.size();
    }

    public void setGameMap(Class<GameMap> gameMapClass) {
        try {
            map = gameMapClass.getDeclaredConstructor().newInstance();
        }
        catch (
                Exception e
        ) {
            e.printStackTrace();
        }
    }

    public void createGameMap() {
        map.createMap();

    }

    public void moveArmies(TerritoryState a, TerritoryState b,int amount) {
        if (!(amount<2 && amount>a.getArmies()-1) && attackPhase(a, b)) {
            a.decArmies(amount);
            b.incArmies(amount);
        }
    }

    public void  placeArmies(TerritoryState territory, int amount) {
        territory.setArmies(amount);
    }

    public void draftPhase() {
        currentplayer = players.get(++roundCount % playerCount);
        roundCount++;
        ArrayList<TerritoryState> territoriesowned = new ArrayList<TerritoryState>();
        int armies;
        int players = getPlayerCount();
        switch(getPlayerCount()) {
            case 2:
                armies = 40;
                break;
            case 3:
                armies = 35;
                break;
            case 4:
                armies = 30;
                break;
            case 5:
                armies = 25;
                break;
            case 6:
                armies = 20;
                break;
        }
        if (new Random().nextDouble() < 0.30) {
            currentcard = new ChanceCard();
        }
        for (TerritoryState terr : MapState.createFromMap(map).getTerritories().values()) {
            if (terr.getOwner() == currentplayer) {
                territoriesowned.add(terr);
            }
        }
    }

    public boolean attackPhase(TerritoryState startLocation, TerritoryState attackLocation) {
        currentplayer = players.get(++roundCount % playerCount);
        //Should modify MapState
        if (MapState.createFromMap(map).getAttackingTerritories(currentplayer).containsValue(startLocation)  && MapState.createFromMap(map).getAttackableTerritoriesFrom(startLocation).containsValue(attackLocation)) {
            Scanner inputarmies = new Scanner(System.in);
            int armies = 0;
            while(armies<2 && armies<startLocation.getArmies() -1){
                armies = inputarmies.nextInt();
            }
            while (attackLocation.getArmies()>0) {
                if (attackLocation.getArmies() == 0) {
                    break;
                }
                int attackerdice = Dice.roll();
                int defenderdice = Dice.roll();
                if (attackerdice<defenderdice) {
                    startLocation.decArmies(2);
                }
                else if (defenderdice<attackerdice){
                    attackLocation.decArmies(1);
                }
            }
            attackLocation.setOwner(currentplayer);
            return true;
        }

        return false;
    }

    public void fortifyPhase(TerritoryState stateToSendArmiesFrom, TerritoryState stateToSendArmiesTo, int amount) {
        if (amount<=stateToSendArmiesFrom.getArmies()) {
            stateToSendArmiesFrom.decArmies(amount);
            stateToSendArmiesTo.incArmies(amount);
        }}

}
