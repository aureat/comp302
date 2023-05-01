package domain.model.game;


public class Game {

    private static GameConfig config;

    private static class GameContainer {
        private static Game instance;
    }

    public static Game getInstance() {
        return GameContainer.instance;
    }

    private Game() {

    }

    public static void useConfig(GameConfig config) {
        Game.config = config;
    }

}
