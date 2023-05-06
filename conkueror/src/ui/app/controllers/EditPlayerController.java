package ui.app.controllers;

import domain.player.Avatars;
import domain.player.Colors;
import domain.player.Player;
import ui.app.Context;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;
import ui.components.player.BigPlayerPreview;

@Controller(at = Route.EditPlayer)
public class EditPlayerController extends ViewController {

    private Player player;
    private BigPlayerPreview preview;

    public EditPlayerController() {
        super();
    }

    public void initialize() {

    }

    public void onRoute(Player player) {
        this.player = player;
    }

    @Override
    public void onUpdate() {
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setColor(String color) {
        player.setColor(Colors.getColorType(color));
        preview.updateColor();
    }

    public void setAvatar(Avatars.AvatarType avatar) {
        player.setAvatar(avatar);
        preview.updateAvatar();
    }

    public void setName(String name) {
        player.setName(name);
        preview.updateText();
    }

    public void setPreview(BigPlayerPreview preview) {
        this.preview = preview;
    }

    public void updatePreview() {
        preview.update();
    }

    public void randomizePlayer(BigPlayerPreview preview) {
        player.generateCharacter();
        preview.updateColor();
        preview.updateAvatar();
        preview.updateText();
    }

    public void savePlayer() {
        redirect(Route.Players);
    }

}
