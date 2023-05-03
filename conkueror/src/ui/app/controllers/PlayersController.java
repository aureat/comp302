package ui.app.controllers;

import domain.game.Game;
import domain.player.Player;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

import java.util.List;

@Controller(at = Route.Players)
public class PlayersController extends ViewController {

    private final Game game;

    public PlayersController() {
        super();
        game = Game.getInstance();
    }

    public Player addPlayer() {
        return game.addPlayer();
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public int getPlayersCount() {
        return game.getPlayersCount();
    }

    public void initialize() {

    }

}
