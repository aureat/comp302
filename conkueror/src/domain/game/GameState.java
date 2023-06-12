package domain.game;

import domain.card.*;
import domain.game.config.GameConfig;
import domain.gamemap.GameMap;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import domain.player.PlayerGenerator;
import util.CoreUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameState {

    /*
     * Turn Information
     */
    private Phase phase;
    private int roundCounter;
    private Dice dice;
    private int draftArmies;

    /*
     * Deck Information
     */
    private Deck deck;
    private ChanceCard currentChanceCard;

    /*
     * Map Information
     */
    private GameMap map;
    private MapState mapState;
    private TerritoryState selectedTerritory;

    /*
     * Player Information
     */
    private List<Player> players;
    private Player currentPlayer;
    private PlayerGenerator playerGenerator;
    private List<Player> cachedPlayers;


    protected GameState() {
        roundCounter = 0;
        dice = new Dice();
        draftArmies = 0;
        playerGenerator = new PlayerGenerator();
        players = playerGenerator.generateInitial();
        cachedPlayers = new ArrayList<>();
    }

    public void createGameMap(GameMap map) {
        this.map = map;
        map.createMap();
        mapState = new MapState(map);
    }

    public GameMap getMap() {
        return map;
    }

    public MapState getMapState() {
        return mapState;
    }

    public Phase getPhase() {
        return phase;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public int getPlayersCount() {
        return players.size();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player addPlayer() {
        if (getPlayersCount() < GameConfig.get().getMaximumPlayers()) {
            Player player = playerGenerator.generate();
            players.add(player);
            return player;
        }
        return null;
    }

    public void removePlayer(Player player) {
        if (players.contains(player) && getPlayersCount() > GameConfig.get().getMinimumPlayers()) {
            players.remove(player);
        }
    }

    public void removePlayerFromGame(Player player) {
        players.remove(player);
        cachedPlayers.add(player);
    }

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public int getStartingArmies() {
        return GameConfig.get().getInitialArmies(players.size());
    }

    public void setSelectedTerritory(TerritoryState state) {
        this.selectedTerritory = state;
    }

    public void shareTerritories() {

        // distribute territories
        int territoryCount = Math.floorDiv(mapState.getTerritoryStates().size(), players.size());
        mapState.getTerritoryStates().forEach(territory -> {
            Player player = CoreUtils.chooseRandom(players);
            if (territory.isPlayable() && territoryCount > player.getTerritoryCount() && territory.getOwner() == null) {
                if (!player.getTerritories().contains(territory)) {
                    player.addTerritory(territory);
                    territory.setOwner(player);
                }
                List<TerritoryState> neighbors = mapState.getNeighborsOf(territory);
                neighbors.forEach(neighbor -> {
                    if (territoryCount > player.getTerritoryCount() && neighbor.getOwner() == null) {
                        if (!player.getTerritories().contains(neighbor)) {
                            player.addTerritory(neighbor);
                            neighbor.setOwner(player);
                        }
                    }
                });
            }
        });

        // if there are remaining territories
        List<TerritoryState> remaining = mapState.getTerritoryStates().stream().filter(state -> state.getOwner() == null).toList();

        // distribute remaining territories
        if (remaining.size() > 0) {
            mapState.getTerritoryStates().forEach(state -> {
                if (state.getOwner() == null) {
                    players.forEach(player -> {
                        if (player.getTerritoryCount() < territoryCount) {
                            if (!player.getTerritories().contains(state)) {
                                player.addTerritory(state);
                                state.setOwner(player);
                            }
                        }
                    });
                    if (state.getOwner() == null) {
                        Player luckyPlayer = CoreUtils.chooseRandom(players);
                        if (!luckyPlayer.getTerritories().contains(state)) {
                            luckyPlayer.addTerritory(state);
                            state.setOwner(luckyPlayer);
                        }
                    }
                }
            });
        }

        // distribute armies
        int armies = (int) Math.ceil((double) getStartingArmies() / map.getTerritories().size() * getPlayersCount());
        mapState.getTerritoryStates().forEach(state -> {
            if (state.getOwner() != null) {
                state.setArmies(armies);
            }
        });

    }

    public int getDraftArmies() {
        return draftArmies;
    }

    public void giveDraftArmies() {
        draftArmies = Math.floorDiv(currentPlayer.getTerritoryCount(), 3);
    }

    public void nextPhase() {

        // if game is not started yet, start it
        if (phase == null) {
            shufflePlayers();
            shareTerritories();
            deck = new Deck(map, players.size());
            phase = Phase.Draft;
            currentPlayer = players.get(0);
            System.out.println(players.size());
            giveDraftArmies();
        }

        // if it's a draft phase, go to attack
        else if (phase == Phase.Draft) {
            phase = Phase.Attack;
        }

        // if it's an attack phase, go to fortify
        else if (phase == Phase.Attack) {
            phase = Phase.Fortify;
        }

        // if it's a fortify phase, go to draft
        else if (phase == Phase.Fortify) {

            // award cards
            drawFromDeck();
            resetChanceCard();
            currentPlayer.removeAllEffects();

            // change phase and round
            phase = Phase.Draft;
            if (players.indexOf(currentPlayer) == players.size()) {
                roundCounter++;
            }

            // change player
            currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());

            // award chance card
            drawChanceCard();

            // give draft armies
            giveDraftArmies();

        }

    }

    public boolean canGoToNextPhase() {
        if (phase == null) {
            return true;
        } else if (phase == Phase.Draft) {
            return draftArmies == 0;
        } else if (phase == Phase.Attack) {
            return true;
        } else {
            return phase == Phase.Fortify;
        }
    }

    public void drawFromDeck() {
        Card card = deck.drawCard();
        if (card.getCardType() == CardType.Army) {
            currentPlayer.addArmyCard((ArmyCard) card);
        } else if (card.getCardType() == CardType.Territory) {
            currentPlayer.addTerritoryCard((TerritoryCard) card);
        }
    }

    public void drawChanceCard() {
        currentChanceCard = deck.drawChanceCard();
    }

    public boolean isChanceCardDrawn() {
        return currentChanceCard != null;
    }

    public void resetChanceCard() {
        currentChanceCard = null;
    }

    public void performDraft(TerritoryState territory) {
        if (territory.getOwner() != currentPlayer || draftArmies == 0) {
            return;
        }

        territory.addArmies(1);
        draftArmies--;
    }

    public void conquerTerritory(TerritoryState territory) {
        Player previousOwner = territory.getOwner();
        previousOwner.removeTerritory(territory);
        currentPlayer.addTerritory(territory);
        territory.setOwner(currentPlayer);
        territory.addArmies(1);
    }

    public void performAttack(TerritoryState from, TerritoryState to) {

        if (from.getArmies() < 3 || from.getOwner() != currentPlayer || to.getOwner() == currentPlayer) {
            return;
        }

        // randomly decide winner
        Player previousOwner = to.getOwner();
        dice.setPlayers(currentPlayer, previousOwner);
        dice.decideWinner();

        // remove armies from both territories
        if (dice.hasWon()) {
            from.removeArmies(1);
            to.removeArmies(1);
        }

        // if the defender has no armies left,
        // remove 1 army from the attacker and conquer the territory
        if (to.getArmies() < 1) {
            from.removeArmies(1);
            conquerTerritory(to);
        }

        // if the previous owner lost all territories, remove him from the game
        if (!previousOwner.hasAnyTerritory()) {
            removePlayerFromGame(previousOwner);
        }

        // if the attacker lost, remove 2 armies
        if (!dice.hasWon()) {
            from.removeArmies(2);
        }

    }

    public void performFortify(TerritoryState from, TerritoryState to) {
        if (from.getArmies() < 2 || from.getOwner() != to.getOwner()) {
            return;
        }

        from.removeArmies(1);
        to.addArmies(1);
    }

    public ChanceCard getCurrentChanceCard() {
        return currentChanceCard;
    }

    public boolean isComputersTurn() {
        return currentPlayer.isComputer();
    }

    public boolean isGameOver() {
        return players.size() == 1;
    }

    public void endGame() {
        removePlayerFromGame(players.get(0));
        phase = Phase.GameOver;
    }

}
