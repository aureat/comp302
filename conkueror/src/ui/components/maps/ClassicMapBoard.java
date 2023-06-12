package ui.components.maps;

import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import ui.components.map.MapBoard;
import ui.components.map.MapTerritory;
import ui.service.MapController;
import ui.graphics.map.ClassicMapGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClassicMapBoard extends MapBoard {

    public ClassicMapBoard(MapController.Mode mode) {
        super(mode);
        initComponent();
        paintTerritories();
    }

    public void initComponent() {
        setLayout(null);
        setSize(1091, 710);
        setPreferredSize(new Dimension(1091, 710));
        setOpaque(false);
    }

    public void paintTerritories() {
        for (ClassicMapGraphics.TerritoryShape territoryShape : ClassicMapGraphics.TerritoryShape.values()) {
            drawTerritory(territoryShape.getName(), territoryShape.getShape(), territoryShape.getX(), territoryShape.getY());
        }
        revalidate();
        repaint();
    }

    public void paintOutlines(Graphics2D g) {
        Arrays.stream(ClassicMapGraphics.OutlineShape.values())
                .forEach(s -> drawOutline(g, s.getShape(), s.getX(), s.getY()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        paintOutlines(g2d);
        g2d.dispose();
    }

}
