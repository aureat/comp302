package domain.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.Collections;

import domain.game.Phase;
import domain.maps.ClassicMap;
import domain.player.Player;
import domain.game.config.GameConfig;
import domain.gamemap.GameMap;
import domain.util.CoreUtils;
import domain.card.ChanceCard;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.gamemap.TerritoryType;

public class Game {

    private static GameConfig config;
    private MapState mapState;
    private final GameMap map = new ClassicMap();
    private final List<Player> players = new ArrayList<>();
    private int playerCount;
    private Phase phase = Phase.Draft;
    private Player currentplayer;

    private int phaseCounter;
    private int turnCounter;
    private int roundCounter;
    private int draftArmies;
    private ChanceCard currentcard;
    private ArrayList<TerritoryState> initialTerrDistrubution;

    private int roundCount;

    public void nextPhase() {
        if(phase == Phase.Draft) {
            phase = Phase.Attack;
        } else if (phase == Phase.Attack) {
            phase = Phase.Fortify;

        } else if (phase == Phase.Fortify) {
            phase = Phase.Draft;
            if (players.indexOf(currentplayer) == players.size()){
                roundCounter++;
            }
            currentplayer = players.get((players.indexOf(currentplayer) + 1) % players.size());
            doDraftPhase();
        }
    }

    private static class GameContainer {
        private static final Game instance = new Game();
    }

    public static Game getInstance() {
        return GameContainer.instance;
    }

    public int getPlayerCount() {
        return players.size();
    }

    private Game() {
        findAndSetConfig();
        initializePlayers();
    }

    public Phase getPhase() {
        return phase;
    }

    private void initializePlayers() {
        IntStream.range(0, config.getInitialPlayers())
                .forEach(i -> addPlayer());
    }

    public void doDraftPhase() {
        draftArmies = Math.floorDiv(currentplayer.getTerritoryCount(), 2);
    }

    public int getDraftArmies() {
        return draftArmies;
    }

    public void setDraftArmies(TerritoryState state) {
        if (draftArmies > 0) {
            state.addArmies(1);
            draftArmies--;
        }
    }
    public Player getCurrentplayer(){ return currentplayer; }

    public void createGameMap() {
        map.createMap();
        mapState = MapState.createInstance(map);
    }

    public Player addPlayer() {
        if (getPlayersCount() < config.getMaximumPlayers()) {
            Player player = new Player();
            players.add(player);
            return player;
        }
        return null;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public void selectTerritories(){
       mapState.getTerritoryStates().forEach(territory ->{
           if(territory.isPlayable() && (territory.getOwner()==null)){
               List<TerritoryState> neighbors = mapState.getNeighborsOf(territory);
               Player player = currentplayer;
               player.addTerritory(territory);
               territory.setOwner(player);
               for(TerritoryState neighbor : neighbors){
                   if(neighbor.isPlayable() && (neighbor.getOwner()==null)){
                       player.addTerritory(neighbor);
                       neighbor.setOwner(player);
                   }
               }
           }
       });
    }

    public void shareTerritories() {
        mapState.getTerritoryStates().forEach(territory -> {
            if (territory.isPlayable()) {
                Player player = CoreUtils.chooseRandom(players);
                player.addTerritory(territory);
                territory.setOwner(player);
            }
        });
        int armies = getInitialArmies();
        mapState.getTerritoryStates().forEach(state -> {
            state.setArmies(Math.floorDiv(armies,state.getOwner().getTerritoryCount()));
        });

        currentplayer = players.get(0);
        doDraftPhase();
    }

    public int getInitialArmies(){
        int armies;
        int players = getPlayerCount();
        switch(players) {
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
            default:
                armies = 40;
                break;
        }
        return armies;
    }

    public void attackPhase(TerritoryState startLocation, TerritoryState attackLocation) {

        boolean condition;
        //This could be work on clicked
        Dice dice = new Dice();
        if (startLocation.getArmies() > attackLocation.getArmies()){
            condition = true;
            while(condition){
                //Roll the dice
                boolean diceValue;
                int diceValueStart = dice.roll();
                int diceValueAttack = dice.roll();
                if(diceValueStart > diceValueAttack){
                    diceValue = true;
                }
                else{
                    diceValue = false;
                }
                //Check the dice condition
                if (diceValue){//To be true if start location won.
                    attackLocation.setArmies(attackLocation.getArmies()-1);
                }
                else {
                    startLocation.setArmies(startLocation.getArmies() - 1);
                }
                //Check the current value of territories
                if (startLocation.getArmies() <= attackLocation.getArmies()){
                    condition = false;
                    break;
                }
                //Look at the current condition.
                //If wanted add a click here.
                if (startLocation.getArmies() > attackLocation.getArmies()){
                    condition = true;
                }
            }
        }
    }

    public void fortifyPhase(TerritoryState stateToSendArmiesFrom, TerritoryState stateToSendArmiesTo, int amount) {
        if (amount<=stateToSendArmiesFrom.getArmies()) {
            stateToSendArmiesFrom.removeArmies(amount);
            stateToSendArmiesTo.addArmies(amount);
        }}

    private void findAndSetConfig() {
        try {
            config = GameConfig.scanConfig();
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
