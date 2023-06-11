package domain.game;

import domain.card.ChanceCard;
import domain.game.config.GameConfig;
import domain.gamemap.GameMap;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.player.Player;

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

    public Player getCurrentPlayer() {
        return gameState.getCurrentPlayer();
    }

    public boolean canApplyArmyCard() {
        return getCurrentPlayer().canApplyArmyCards();
    }

    public void applyArmyCard() {
        // TODO: Implement
    }

    public boolean canApplyTerritoryCard() {
        return getCurrentPlayer().canApplyTerritoryCards();
    }

    public void applyTerritoryCard() {
        // TODO: Implement
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

    public void continueGame() {
        // TODO: Implement
    }

}
