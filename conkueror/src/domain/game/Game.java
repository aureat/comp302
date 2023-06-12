package domain.game;

import domain.card.ChanceCard;
import domain.game.config.GameConfig;
import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import util.CoreUtils;

import java.util.List;

public class Game {

    private static class GameContainer {
        private static Game instance;
    }

    public static Game getInstance() {
        if (GameContainer.instance == null) {
            GameContainer.instance = new Game();
        }
        return GameContainer.instance;
    }

    public static void destroyInstance() {
        GameContainer.instance = null;
    }

    private GameState gameState;

    private Game() {

    }

    public void setSelectedTerritory(TerritoryState state) {
        gameState.setSelectedTerritory(state);
    }

    public void nextPhase() {
        gameState.nextPhase();
    }

    public Phase getPhase() {
        return gameState.getPhase();
    }

    public int getDraftArmies() {
        return gameState.getDraftArmies();
    }

    public boolean isComputersTurn() {
        return gameState.isComputersTurn();
    }

    public GameMap getMap() {
        return gameState.getMap();
    }

    public MapState getMapState() {
        return gameState.getMapState();
    }

    public List<GameMap> getAllMaps() {
        return GameConfig.get().getMaps();
    }

    public void selectGameMap(GameMap map) {
        gameState.createGameMap(map);
    }

    public Player addPlayer() {
        return gameState.addPlayer();
    }

    public void shareTerritories() {
        gameState.shareTerritories();
    }

    public Player getCurrentPlayer() {
        return gameState.getCurrentPlayer();
    }

    public List<Player> getPlayers() {
        return gameState.getPlayers();
    }

    public int getPlayersCount() {
        return gameState.getPlayersCount();
    }

    public boolean canApplyArmyCard() {
        return getCurrentPlayer().canApplyArmyCards();
    }

    public void applyArmyCard() {
        // TODO: Implement
        //territory to add army card
        if(getPhase().equals(Phase.Draft)){
            TerritoryState terr = CoreUtils.chooseRandom(Game.getInstance().getCurrentPlayer().getTerritories());
            int cardTradeResult = GameConfig.get().getArmyCardTradeResult(Game.getInstance().getCurrentPlayer().getArmyCards());
            terr.setArmies(terr.getArmies()+cardTradeResult);
        }



    }

    public boolean canApplyTerritoryCard() {
        return getCurrentPlayer().canApplyTerritoryCards();
    }

    public void applyTerritoryCard() {
        // TODO: Implement
        if(canApplyTerritoryCard()){

        }
    }

    public boolean canApplyChanceCard() {
        return gameState.isChanceCardDrawn();
    }

    public ChanceCard getCurrentChanceCard() {
        return gameState.getCurrentChanceCard();
    }

    public void applyChanceCard() {
        ChanceCard card = gameState.getCurrentChanceCard();
        getCurrentPlayer().addEffect(card.getEffect());
        card.apply();
    }

    public void createNewGame() {
        gameState = new GameState();
    }

    public void createMap() {
        GameMap map = GameConfig.get().getMap("Classic");
        gameState.createGameMap(map);
    }

    public void continueGame() {
        // TODO: Implement
    }

}
