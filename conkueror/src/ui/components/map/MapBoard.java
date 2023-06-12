package ui.components.map;

import domain.mapstate.TerritoryState;
import ui.graphics.map.MapGraphicsDefault;
import ui.service.MapController;

import javax.swing.*;
import java.awt.*;

public abstract class MapBoard extends JPanel {

    private final MapController controller;

    public MapBoard(MapController.Mode mode) {
        controller = MapController.createFor(this);
        MapController.get().setMode(mode);
    }

    public MapController getController() {
        return controller;
    }

    public void drawTerritory(String name, Shape shape, int x, int y) {
        TerritoryState state = MapController.get().getTerritoryState(name);
        MapTerritory territory = new MapTerritory(state, shape, x, y);
        territory.setBounds(x, y, (int) shape.getBounds().getWidth(), (int) shape.getBounds().getHeight());
        MapController.get().addMapTerritory(state, territory);
        add(territory);
    }

    public void drawOutline(Graphics g, Shape shape, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphicsDefault.continentStroke));
        g2d.translate(x, y);
        g2d.fill(shape);
        g2d.draw(shape);
        g2d.dispose();
    }

}
