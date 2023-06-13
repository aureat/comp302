package domain.game;

import domain.card.ChanceCard;
import domain.card.TerritoryCard;
import domain.game.config.GameConfig;
import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.gamemap.TerritoryType;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import ui.service.GameController;
import ui.service.MapController;
import util.CoreUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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

    private static final String SAVE_FILE = "save/state.ser";

    private GameState gameState;

    public TerritoryState nukeTo;
    public TerritoryState revoltFrom;
    public TerritoryState revoltTo;
    public TerritoryState reinforcementsTo;
    public TerritoryState armiesTo;

    public TerritoryState selectedByAI;

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
        if (isComputersTurn() && getPhase() == Phase.Draft) {
            performDraftAI();
        }
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

    public void performDraftAI() {
        List<TerritoryState> territories = getMapState().getTerritoryStates(getCurrentPlayer());
        territories.stream()
                .filter(territoryState -> territoryState.isPlayable() && getMapState().getAttackableNeighborsOf(territoryState).size() > 0)
                .findFirst()
                .ifPresent(territoryState -> {
                    selectedByAI = territoryState;
                });
        if (selectedByAI != null) {
            selectedByAI.setArmies(gameState.getDraftArmies());
            gameState.setDraftArmies(0);
        }
        nextPhase();
        performAttackAI();
    }

    public void performAttackAI() {
        if (selectedByAI != null) {
            while (selectedByAI.canStartAttack()) {
                List<TerritoryState> attackableNeighbor = getMapState().getAttackableNeighborsOf(selectedByAI);
                if (attackableNeighbor.size() == 0) {
                    break;
                }
                gameState.performAttack(selectedByAI, attackableNeighbor.get(0));
            }
        }
        selectedByAI = null;
        nextPhase();
        performFortifyAI();
    }

    public void performFortifyAI() {
        List<TerritoryState> territories = new ArrayList<>(getMapState().getTerritoryStates(getCurrentPlayer())
                .stream().filter(territoryState -> territoryState.isPlayable() && territoryState.getArmies() > 1).toList());
        TerritoryState from = CoreUtils.chooseRandom(territories);
        territories.remove(from);
        TerritoryState to = CoreUtils.chooseRandom(territories);
        if (from != null && to != null) {
            int times = new Random().nextInt(0, from.getArmies() - 1);
            for (int i = 0; i < times; i++) {
                gameState.performFortify(from, to);
            }
        }
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

        // Find the continent that the player has all the territories of
        Player currentPlayer = getCurrentPlayer();
        List<TerritoryCard> territoryCards = currentPlayer.getTerritoryCards();
        List<ContinentType> continents = getMap().getContinents();
        ContinentType selectedContinent = continents.get(0);
        for (ContinentType continent : continents) {
            List<TerritoryType> continentTerritories = continent.getTerritories();
            if (continentTerritories.stream().allMatch(territory -> territoryCards.stream().anyMatch(card -> card.getTerritoryType() == territory))) {
                selectedContinent = continent;
                break;
            }
        }

        // Find territories of the continent
        List<TerritoryState> territories = getMapState().getTerritoryStates(selectedContinent);
        territories.forEach(territory -> {
            if (territory.getOwner() != currentPlayer) {
                gameState.conquerTerritory(territory);
            }
        });

    }

    public boolean canApplyChanceCard() {
        return gameState.isChanceCardDrawn() && !getCurrentChanceCard().isUsed();
    }

    public ChanceCard getCurrentChanceCard() {
        return gameState.getCurrentChanceCard();
    }

    public void applyChanceCard() {
        ChanceCard card = gameState.getCurrentChanceCard();
        card.setUsed(true);
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

    public void saveGame() {
        try {
            FileOutputStream fileOut = new FileOutputStream(SAVE_FILE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(gameState);
            objectOut.close();
            System.out.println("The GameState was successfully written to a file");
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public void loadGame() {
        gameState = null;
        try {
            FileInputStream fileIn = new FileInputStream(SAVE_FILE);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            gameState = (GameState) objectIn.readObject();
            objectIn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

}
