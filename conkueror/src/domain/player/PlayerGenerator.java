package domain.player;

import domain.game.config.GameConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PlayerGenerator {

    public PlayerGenerator() {
        Avatars.initialize();
        Colors.initialize();
        Names.initialize();
    }

    public Player generate() {
        return new Player();
    }

    public Player generate(boolean isComputer) {
        Player player = generate();
        player.setComputer(isComputer);
        return player;
    }

    public List<Player> generateInitial() {
        List<Player> players = new ArrayList<>();
        IntStream.range(0, GameConfig.get().getInitialPlayers())
                .forEach(i -> {
                    Player player = generate();
                    if (i != 0) {
                        player.setComputer(true);
                    }
                    players.add(player);
                });
        return players;
    }

}
