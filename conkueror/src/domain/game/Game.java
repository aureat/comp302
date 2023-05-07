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

    private ChanceCard currentcard;
    private ArrayList<TerritoryState> initialTerrDistrubution;

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
            if (territory.isPlayable()) {
                Player player = CoreUtils.chooseRandom(players);
                player.addTerritory(territory);
                territory.setOwner(player);
            }
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
