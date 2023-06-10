package domain.game;

import domain.game.config.GameConfig;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import domain.player.PlayerGenerator;

import java.util.Collections;
import java.util.List;

public class GameState {

    private int roundCounter;
    private Phase phase = Phase.Draft;
    private Player currentPlayer;
    private boolean isPlayedByComputer;

    private int draftArmies;

    private TerritoryState selectedTerritory;

    private List<Player> players;
    private final PlayerGenerator playerGenerator = new PlayerGenerator();

    public GameState() {

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

    public void createInitialPlayers() {
        players = playerGenerator.generateInitial();
    }

    public Player addPlayer() {
        if (getPlayersCount() < GameConfig.get().getMaximumPlayers()) {
            Player player = playerGenerator.generate();
            players.add(player);
            return player;
        }
        return null;
    }

    public void shufflePlayers() {
        Collections.shuffle(players);
    }

    public int getDraftArmies() {
        return draftArmies;
    }

    public void giveDraftArmies() {
        draftArmies = Math.floorDiv(currentPlayer.getTerritoryCount(), 2);
    }

    public void nextPhase() {
        if (phase == Phase.Draft) {
            phase = Phase.Attack;
        } else if (phase == Phase.Attack) {
            phase = Phase.Fortify;
        } else if (phase == Phase.Fortify) {
            // change phase and round
            phase = Phase.Draft;
            if (players.indexOf(currentPlayer) == players.size()) {
                roundCounter++;
            }

            // change player
            currentPlayer = players.get((players.indexOf(currentPlayer) + 1) % players.size());
            isPlayedByComputer = currentPlayer.isComputer();

            // give draft armies
            giveDraftArmies();
        }
    }

}
