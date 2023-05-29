package ui.components.map;

import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import ui.app.controllers.MapController;
import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class WorldMap extends JPanel {

    private MapState state;
    private MapGraphics mapGraphics = MapGraphics.getInstance();
    private List<MapTerritory> territories = new ArrayList<>();

    private MapTerritory hoveredTerritory;
    private MapTerritory selectedTerritory;

    private final boolean isBuildMode;

    public WorldMap(boolean isBuildMode) {
        setLayout(null);
        setSize(1091, 710);
        setPreferredSize(new Dimension(1091, 710));
        setOpaque(false);
        this.isBuildMode = isBuildMode;
        MapController.map = this;
    }

    public List<MapTerritory> getTerritories() {
        return territories;
    }

    public boolean isBuildMode() {
        return isBuildMode;
    }

    public void setMapState() {
        state = MapState.getInstance();
        initComponent();
        for (MapTerritory territory : territories) {
            territory.setBounds(territory.getX(), territory.getY(),
                    (int) territory.getShape().getBounds().getWidth(), (int) territory.getShape().getBounds().getHeight());
            if (isBuildMode)
                territory.setBuildMode();
            add(territory);
            territory.setVisible(true);
            territory.update();
            territory.repaint();
        }
        revalidate();
        repaint();
    }

    public void setHoveredTerritory(MapTerritory territory) {
        hoveredTerritory = territory;
        repaint();
    }

    public void setSelectedTerritory(MapTerritory territory) {
        selectedTerritory = territory;
        repaint();
    }

    public MapTerritory getHoveredTerritory() {
        return hoveredTerritory;
    }

    public MapTerritory getSelectedTerritory() {
        return selectedTerritory;
    }

    public void initComponent() {
        territories.add(new MapTerritory(state.getTerritoryState("Alaska"), mapGraphics.shapeAlaska, 7, 50));
        territories.add(new MapTerritory(state.getTerritoryState("Greenland"), mapGraphics.shapeGreenland, 272, 7));
        territories.add(new MapTerritory(state.getTerritoryState("Northwest"), mapGraphics.shapeNorthwest, 78, 36));
        territories.add(new MapTerritory(state.getTerritoryState("Alberta"), mapGraphics.shapeAlberta, 78, 93));
        territories.add(new MapTerritory(state.getTerritoryState("Ontario"), mapGraphics.shapeOntario, 156, 97));
        territories.add(new MapTerritory(state.getTerritoryState("Quebec"), mapGraphics.shapeQuebec, 227, 93));
        territories.add(new MapTerritory(state.getTerritoryState("Western America"), mapGraphics.shapeWesternAmerica, 62, 156));
        territories.add(new MapTerritory(state.getTerritoryState("Eastern America"), mapGraphics.shapeEasternAmerica, 111, 156));
        territories.add(new MapTerritory(state.getTerritoryState("Central America"), mapGraphics.shapeCentralAmerica, 58, 227));
        territories.add(new MapTerritory(state.getTerritoryState("Venezuela"), mapGraphics.shapeVenezuela, 113, 317));
        territories.add(new MapTerritory(state.getTerritoryState("Peru"), mapGraphics.shapePeru, 100, 368));
        territories.add(new MapTerritory(state.getTerritoryState("Brazil"), mapGraphics.shapeBrazil, 132, 351));
        territories.add(new MapTerritory(state.getTerritoryState("Argentina"), mapGraphics.shapeArgentina, 95, 461));
        territories.add(new MapTerritory(state.getTerritoryState("Indonesia"), mapGraphics.shapeIndonesia, 779, 411));
        territories.add(new MapTerritory(state.getTerritoryState("New Guinea"), mapGraphics.shapeNewGuinea, 943, 408));
        territories.add(new MapTerritory(state.getTerritoryState("Eastern Australia"), mapGraphics.shapeEasternAustralia, 942, 496));
        territories.add(new MapTerritory(state.getTerritoryState("Western Australia"), mapGraphics.shapeWesternAustralia, 873, 516));
        territories.add(new MapTerritory(state.getTerritoryState("North Africa"), mapGraphics.shapeNorthAfrica, 363, 298));
        territories.add(new MapTerritory(state.getTerritoryState("Egypt"), mapGraphics.shapeEgypt, 480, 318));
        territories.add(new MapTerritory(state.getTerritoryState("East Africa"), mapGraphics.shapeEastAfrica, 533, 376));
        territories.add(new MapTerritory(state.getTerritoryState("Congo"), mapGraphics.shapeCongo, 466, 425));
        territories.add(new MapTerritory(state.getTerritoryState("South Africa"), mapGraphics.shapeSouthAfrica, 466, 504));
        territories.add(new MapTerritory(state.getTerritoryState("Madagascar"), mapGraphics.shapeMadagascar, 630, 517));
        territories.add(new MapTerritory(state.getTerritoryState("Russia"), mapGraphics.shapeRussia, 650, 4));
        territories.add(new MapTerritory(state.getTerritoryState("Mongolia"), mapGraphics.shapeMongolia, 635, 145));
        territories.add(new MapTerritory(state.getTerritoryState("Japan"), mapGraphics.shapeJapan, 937, 134));
        territories.add(new MapTerritory(state.getTerritoryState("China"), mapGraphics.shapeChina, 730, 155));
        territories.add(new MapTerritory(state.getTerritoryState("India"), mapGraphics.shapeIndia, 688, 235));
        territories.add(new MapTerritory(state.getTerritoryState("Southern Europe"), mapGraphics.shapeSouthernEurope, 452, 210));
        territories.add(new MapTerritory(state.getTerritoryState("Anatolia"), mapGraphics.shapeAnatolia, 495, 192));
        territories.add(new MapTerritory(state.getTerritoryState("Middle East"), mapGraphics.shapeMiddleEast, 537, 245));
        territories.add(new MapTerritory(state.getTerritoryState("Siam"), mapGraphics.shapeSiam, 808, 289));
        territories.add(new MapTerritory(state.getTerritoryState("Great Britain"), mapGraphics.shapeGreatBritain, 346, 123));
        territories.add(new MapTerritory(state.getTerritoryState("Iceland"), mapGraphics.shapeIceland, 392, 75));
        territories.add(new MapTerritory(state.getTerritoryState("Scandinavia"), mapGraphics.shapeScandinavia, 465, 55));
        territories.add(new MapTerritory(state.getTerritoryState("Northern Europe"), mapGraphics.shapeNorthernEurope, 452, 144));
        territories.add(new MapTerritory(state.getTerritoryState("Western Europe"), mapGraphics.shapeWesternEurope, 372, 196));
        territories.add(new MapTerritory(state.getTerritoryState("Eastern Europe"), mapGraphics.shapeEasternEurope, 527, 55));
        territories.add(new MapTerritory(state.getTerritoryState("Persia"), mapGraphics.shapePersia, 589, 187));
    }

    public void drawOutline(Graphics g, Shape shape, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphics.continentStroke));
        g2d.translate(x, y);
        g2d.fill(shape);
        g2d.draw(shape);
    }

    public void updateOnMap(TerritoryState territoryState) {
        territories.stream().filter(t -> t.getState() == territoryState).findFirst().ifPresent(MapTerritory::update);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        paintOutlines(g2d);
//        g2d.dispose();
    }

    public void paintOutlines(Graphics2D g) {
        drawOutline(g, mapGraphics.shapeNorthAmericaOutline, 1, 38);
        drawOutline(g, mapGraphics.shapeGreenlandOutline, 266, 5);
        drawOutline(g, mapGraphics.shapeSouthAmericaOutline, 95, 315);
        drawOutline(g, mapGraphics.shapeBritainOutline, 345, 118);
        drawOutline(g, mapGraphics.shapeIcelandOutline, 392, 80);
        drawOutline(g, mapGraphics.shapeEuropeOutline, 372, 61);
        drawOutline(g, mapGraphics.shapeAsiaOutline, 534, 10);
        drawOutline(g, mapGraphics.shapeJapanOutline, 934, 140);
        drawOutline(g, mapGraphics.shapeAfricaOutline, 358, 297);
        drawOutline(g, mapGraphics.shapeMadagascarOutline, 626, 512);
        drawOutline(g, mapGraphics.shapeIndonesiaOutline, 775, 412);
        drawOutline(g, mapGraphics.shapeNewGuineaOutline, 939, 408);
        drawOutline(g, mapGraphics.shapeOceaniaOutline, 868, 497);
    }

}
