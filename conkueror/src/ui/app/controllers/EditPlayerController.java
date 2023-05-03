package ui.app.controllers;

import domain.player.Player;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;

@Controller(at = Route.EditPlayer)
public class EditPlayerController extends ViewController {

    private final Player player;

    public EditPlayerController(Player player) {
        super();
        this.player = player;
    }

    public void initialize() {

    }

    public Player getPlayer() {
        return player;
    }

}
