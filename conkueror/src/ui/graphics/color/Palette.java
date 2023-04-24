package ui.graphics.color;

import java.awt.*;

public class Palette {

    // Territory Fills
    public Color territoryFillDisabled, territoryFill, territoryFillHover, territoryFillSelect, territoryFillSelectedHover;
    // Territory Strokes
    public Color territoryStroke;
    // Continent Fills
    public Color continentFillDisabled, continentFill;
    // Continent Strokes
    public Color continentStroke, continentStrokeHighlight;

    public Palette(Color bright, Color dark, Color darker) {
        // Territory Palette
        this.territoryFillDisabled = new Color(213, 213, 213);
        this.territoryFill = dark;
        this.territoryFillHover = makeHoverColor(dark);
        this.territoryFillSelect = bright;
        this.territoryFillSelectedHover = makeHoverColor(bright);
        this.territoryStroke = darker;
        // Continent Palette
        this.continentFillDisabled = new Color(100, 100, 100);
        this.continentFill = new Color(0,0,0);
        this.continentStroke = new Color(0,0 ,0);
        this.continentStrokeHighlight = bright;
    }

    public Color makeHoverColor(Color color) {
        return new Color(color.getRed(), color.getGreen(), color.getBlue(), 204);
    }

}