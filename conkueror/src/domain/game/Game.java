package domain.game;

import domain.card.ChanceCard;
import domain.game.config.GameConfig;
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

    public TerritoryState nukeTo;
    public TerritoryState revoltFrom;
    public TerritoryState revoltTo;
    public TerritoryState reinforcementsTo;
    public TerritoryState armiesTo;

    private Game() {

    }

    public void setSelectedTerritory(TerritoryState state) {
        gameState.setSelectedTerritory(state);
    }

    public GameState getGameState() {
        return gameState;
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
        TerritoryState terr = armiesTo;
        int cardTradeResult = GameConfig.get().getArmyCardTradeResult(Game.getInstance().getCurrentPlayer().getArmyTypes());
        terr.setArmies(terr.getArmies() + cardTradeResult);
        getCurrentPlayer().resetArmyCards();
    }

    public boolean canApplyTerritoryCard() {
        return getCurrentPlayer().canApplyTerritoryCards();
    }

    public void applyTerritoryCard() {

    }

    public boolean canApplyChanceCard() {
        return gameState.isChanceCardDrawn();
    }

    public ChanceCard getCurrentChanceCard() {
        return gameState.getCurrentChanceCard();
    }

    public void applyChanceCard() {
        ChanceCard card = gameState.getCurrentChanceCard();
        card.apply();
        gameState.resetChanceCard();
    }

    public void performDraft(TerritoryState state) {
        gameState.performDraft(state);
    }

    public void performAttack(TerritoryState attacker, TerritoryState defender) {
        gameState.performAttack(attacker, defender);
    }

    public void performFortify(TerritoryState from, TerritoryState to) {
        gameState.performFortify(from, to);
    }

    public List<TerritoryState> getAttackableNeighborsOf(TerritoryState state) {
        return gameState.getMapState().getAttackableNeighborsOf(state);
    }

    public boolean canGoToNextPhase() {
        return gameState.canGoToNextPhase();
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
