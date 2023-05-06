package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

@Controller(at = Route.BuildMap)
public class BuildMapController extends ViewController {

    private final Game game;

    public BuildMapController() {
        super();
        game = Game.getInstance();
    }

    public void initialize() {

    }

}
