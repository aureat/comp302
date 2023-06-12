package ui.app.controllers;

import domain.game.Game;
import domain.game.config.GameConfig;
import domain.player.Player;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;
import ui.components.player.PlayerPreview;

import java.util.ArrayList;
import java.util.List;

@Controller(at = Route.Players)
public class PlayersController extends ViewController {

    private final Game game;
    private final List<PlayerPreview> previews = new ArrayList<>();

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

    public void editPlayer(Player player) {
        redirect(Route.EditPlayer, player);
    }

    public void addPreview(PlayerPreview preview) {
        previews.add(preview);
    }

    @Override
    public void onUpdate() {
        previews.forEach(PlayerPreview::update);
    }

    public void updatePreviewFor(Player player) {
        previews.stream()
                .filter(preview -> preview.getPlayer().equals(player))
                .forEach(PlayerPreview::update);
    }

    public void initialize() {

    }

    public void nextStep() {
        Game.getInstance().createMap();
        redirect(Route.BuildMap);
    }

}
