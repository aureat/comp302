package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

@Controller(at = Route.Pause)
public class PauseController extends ViewController {

    private final Game game;

    public PauseController() {
        super();
        game = Game.getInstance();
    }

    public void initialize() {

    }

}
