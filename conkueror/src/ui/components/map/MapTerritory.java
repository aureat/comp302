package ui.components.map;

import domain.mapstate.TerritoryState;
import ui.graphics.color.ColorGraphics;
import ui.graphics.color.Palette;

import java.awt.*;

public class MapTerritory {

    private TerritoryState state;
    private Shape shape;
    private int x;
    private int y;

    public MapTerritory(TerritoryState state, Shape shape, int x, int y) {
        this.state = state;
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    public TerritoryState getState() {
        return state;
    }

    public Shape getShape() {
        return shape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Palette getPalette() {
        return ColorGraphics.getPalette(state.getOwner().getColor());
    }

    public Color getFillColor() {
        return getPalette().territoryFill;
    }

    public Color getStrokeColor() {
        return getPalette().territoryStroke;
    }

    public Color getHoverColor() {
        return getPalette().territoryFillHover;
    }

}
