package ui.app.controllers;

import ui.components.map.WorldMap;

public class MapController {

    public static WorldMap map;

    public static void update() {
        map.repaint();
    }

    public static void deselectAll() {
        map.getTerritories().forEach(territory -> territory.setSelected(false));
    }

}
