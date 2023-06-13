package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

@Controller(at = Route.GameOver)
public class GameOverController extends ViewController {

    private final Game game;

    public GameOverController() {
        super();
        game = Game.getInstance();
    }

    public void initialize() {

    }

}
