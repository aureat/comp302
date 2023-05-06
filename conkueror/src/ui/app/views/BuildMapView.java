package ui.app.views;

import ui.app.Context;
import ui.app.controllers.BuildMapController;
import ui.app.controllers.MainController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.WorldMap;
import ui.components.core.ImageBtnStack;


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
        setSizeOnCenter(map);

        add(map);

    }

}
