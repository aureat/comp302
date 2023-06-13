package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;
import ui.components.maps.ClassicMapBoard;

@Controller(at = Route.GameMap)
public class GameMapController extends ViewController {

    private final Game game;

    public GameMapController() {
        super();
        game = Game.getInstance();
    }

    public void initialize() {

    }

    public void pause() {

        if (game.isComputersTurn())
            return;

        redirect(Route.Pause);

    }

}
