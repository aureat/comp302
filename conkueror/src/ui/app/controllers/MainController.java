package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

@Controller(at = Route.Main)
public class MainController extends ViewController {

    private final Game game;

    public MainController() {
        super();
        game = Game.getInstance();
    }

    public void initialize() {

    }

    public void newGame() {
        Game.getInstance().createNewGame();
        redirect(Route.Players);
    }

    public void continueGame() {
        Game.getInstance().loadGame();
        redirect(Route.GameMap);
    }

}
