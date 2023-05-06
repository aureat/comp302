package domain.game;


import domain.game.config.GameConfig;
import domain.gamemap.GameMap;
import domain.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Game {

    private static GameConfig config;

    private static class GameContainer {
        private static final Game instance = new Game();
    }

    public static Game getInstance() {
        return GameContainer.instance;
    }

    private Phase phase;
    private Player currentPlayer;
    private GameMap map;

    private final List<Player> players = new ArrayList<>();

    private Game() {
        findAndSetConfig();
        initializePlayers();
    }

    private void initializePlayers() {
        IntStream.range(0, config.getInitialPlayers())
                .forEach(i -> addPlayer());
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

    private void findAndSetConfig() {
        try {
            config = GameConfig.scanConfig();
        } catch (RuntimeException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

}
