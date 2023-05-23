package ui.app.controllers;

import domain.game.Game;
import ui.app.router.Controller;
import ui.app.router.Route;
import ui.app.router.ViewController;
import ui.components.map.WorldMap;

@Controller(at = Route.BuildMap)
public class BuildMapController extends ViewController {

    private final Game game;
    private WorldMap map;

    public BuildMapController() {
        super();
        game = Game.getInstance();
    }

    public void setMap(WorldMap map) {
        this.map = map;
    }

    @Override
    public void onMount() {
        map.setMapState();
    }

    public void nextStep() {
        //game.selectTerritories();
        redirect(Route.GameMap);
    }

    public void initialize() {

    }

}
