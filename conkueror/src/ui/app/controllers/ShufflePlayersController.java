package ui.app.controllers;

import domain.game.Game;
import domain.player.Player;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;
import ui.components.player.PlayerPreview;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller(at = Route.ShufflePlayers)
public class ShufflePlayersController extends ViewController {

    private final Game game;
    private final List<PlayerPreview> previews = new ArrayList<>();

    public ShufflePlayersController() {
        super();
        game = Game.getInstance();
    }

    public List<Player> getPlayers() {
        return game.getPlayers();
    }

    public int getPlayersCount() {
        return game.getPlayersCount();
    }

    public void addPreview(PlayerPreview preview) {
        previews.add(preview);
    }

    public void shufflePlayers() {
        game.shufflePlayers();
    }

    @Override
    public void onUpdate() {

    }

    public void initialize() {

    }

}
