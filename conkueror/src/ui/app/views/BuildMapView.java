package ui.app.views;

import ui.app.controllers.BuildMapController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.map.WorldMap;


@View(at = Route.BuildMap)
public class BuildMapView extends ViewPanel<BuildMapController> {

    private final Assets backgrounds = Assets.Background;

    public BuildMapView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("map");
    }

    public void initialize() {

        // Set Background
        setViewBackground(backgrounds.getAsset("map"));

        WorldMap map = new WorldMap();
        getController().setMap(map);
        setSizeOnCenter(map);

        add(map);

    }

}
