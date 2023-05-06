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
        IntStream.range(0, 6)
                .forEach(i -> addPlayer());
    }

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

    public void shareTerritories() {
        mapState.getTerritoryStates().forEach(territory -> {
            Player player = CoreUtils.chooseRandom(players);
            territory.setOwner(player);
        });
//        List<Player> tempPlayers = new ArrayList<>(players);
//        int i;
//        if (players.size()==2){
//            i=20;
//        } else if (players.size()==3) {
//            i=13;
//        } else if (players.size()==4) {
//            i=10;
//        } else if (players.size()==5) {
//            i=8;
//        }else {
//            i=7;
//        }
//        List<TerritoryState> states = mapState.getTerritoryStates();
//        for(int j =0; j < players.size(); j++) {
//            Player player = CoreUtils.chooseRandom(tempPlayers);
//            while (!states.isEmpty() || i!=0) {
//                TerritoryState state = CoreUtils.chooseRandom(states);
//                state.setOwner(player);
//                List<TerritoryType> neighbors = state.getTerritoryType().getNeighbors();
//                i--;
//                for (TerritoryType neighbor : neighbors) {
//                    TerritoryState neighborState = mapState.getTerritories().get(neighbor);
//                    neighborState.setOwner(player);
//                    states.remove(neighborState);
//                    i--;
//                }
//                states.remove(state);
//            }
//            tempPlayers.remove(player);
//        }
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
