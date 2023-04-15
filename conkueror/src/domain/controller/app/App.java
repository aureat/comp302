package domain.controller.app;

import domain.model.game.Game;

public class App {

    private Game activeGame;

    public App() {
        
    }

    public static void main(String[] args) {

    }

    public void newGame() {
        activeGame = new Game();
    }



}
