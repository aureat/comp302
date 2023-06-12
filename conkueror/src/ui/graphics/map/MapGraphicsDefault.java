package ui.graphics.map;

public class MapGraphicsDefault {

    private static double scale = 1;

    public static void setScale(double newScale) {
        scale = newScale;
    }

    public static double getScale() {
        return scale;
    }

    public static final int continentStroke = 12;
    public static final int territoryStroke = 8;

}
