package ui.graphics.map;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class UniversityMapGraphics {

    private static class MapGraphicsContainer {
        public static final UniversityMapGraphics instance = new UniversityMapGraphics();
    }

    public static UniversityMapGraphics getInstance() {
        return MapGraphicsContainer.instance;
    }

    private static double scale = 1;

    public static final int continentStroke = 12;
    public static final int territoryStroke = 3;

    public static void setScale(double newScale) {
        scale = newScale;
    }

    public static double getScale() {
        return scale;
    }

    public static Shape transformShape(Path2D.Double path) {
        AffineTransform transform = new AffineTransform();
        transform.scale(scale, scale);
        return path.createTransformedShape(transform);
    }

    public static Shape createDormS() {
        Path2D.Double path = new Path2D.Double();

        path.closePath();
        return transformShape(path);
    }

    public final Shape shapeDormS = createDormS();

}