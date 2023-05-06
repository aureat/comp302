package ui.components.map;

import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WorldMap extends JPanel implements MouseListener {

    private MapState state;
    private MapGraphics mapGraphics = MapGraphics.getInstance();
    private List<MapTerritory> territories = new ArrayList<>();

    public WorldMap() {
        setLayout(null);
        setSize(1091, 701);
        setOpaque(false);
    }

    public void setMapState() {
        state = MapState.getInstance();
        initComponent();
        revalidate();
        repaint();
    }

    public void initComponent() {

        territories.add(new MapTerritory(state.getTerritoryState("Alaska"), mapGraphics.shapeAlaska, 7, 50));
        territories.add(new MapTerritory(state.getTerritoryState("Greenland"), mapGraphics.shapeGreenland, 272, 7));
        territories.add(new MapTerritory(state.getTerritoryState("Northwest"), mapGraphics.shapeNorthwest, 78, 36));
        territories.add(new MapTerritory(state.getTerritoryState("Alberta"), mapGraphics.shapeAlberta, 78, 93));
//        territories.add(new MapTerritory(state.getTerritoryState("Ontario"), mapGraphics.shapeOntario, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Quebec"), mapGraphics.shapeQuebec, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Western America"), mapGraphics.shapeWesternAmerica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Eastern America"), mapGraphics.shapeEasternAmerica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Central America"), mapGraphics.shapeCentralAmerica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Venezuela"), mapGraphics.shapeVenezuela, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Peru"), mapGraphics.shapePeru, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Brazil"), mapGraphics.shapeBrazil, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Argentina"), mapGraphics.shapeArgentina, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Indonesia"), mapGraphics.shapeIndonesia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("New Guinea"), mapGraphics.shapeNewGuinea, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Western Australia"), mapGraphics.shapeWesternAustralia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Eastern Australia"), mapGraphics.shapeEasternAustralia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("North Africa"), mapGraphics.shapeNorthAfrica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Egypt"), mapGraphics.shapeEgypt, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("East Africa"), mapGraphics.shapeEastAfrica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Congo"), mapGraphics.shapeCongo, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("South Africa"), mapGraphics.shapeSouthAfrica, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Madagascar"), mapGraphics.shapeMadagascar, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Russia"), mapGraphics.shapeRussia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Mongolia"), mapGraphics.shapeMongolia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Japan"), mapGraphics.shapeJapan, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("China"), mapGraphics.shapeChina, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("India"), mapGraphics.shapeIndia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Middle East"), mapGraphics.shapeMiddleEast, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Siam"), mapGraphics.shapeSiam, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Great Britain"), mapGraphics.shapeGreatBritain, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Iceland"), mapGraphics.shapeIceland, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Scandinavia"), mapGraphics.shapeScandinavia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Northern Europe"), mapGraphics.shapeNorthernEurope, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Western Europe"), mapGraphics.shapeWesternEurope, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Eastern Europe"), mapGraphics.shapeEasternEurope, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Southern Europe"), mapGraphics.shapeSouthernEurope, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Anatolia"), mapGraphics.shapeAnatolia, 0, 0));
//        territories.add(new MapTerritory(state.getTerritoryState("Persia"), mapGraphics.shapePersia, 0, 0));

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        if (shape.getBounds().contains(e.getPoint())) {
//            strokeColor = hoverColor;
//            repaint();
//        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        strokeColor = defaultColor;
//        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e ) {}

    public void drawOutline(Graphics g, Shape shape, int x, int y) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphics.continentStroke));
        g2d.translate(x, y);
        g2d.draw(shape);
    }

    public void drawTerritory(Graphics g, MapTerritory territory) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(MapGraphics.territoryStroke));
        g2d.translate(x, y);
        g2d.draw(shape);
    }

    public void drawTerritories(Graphics g) {
        for (MapTerritory territory : territories) {
            drawTerritory(g, territory);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        paintOutlines(g2d);
        g2d.setColor(Color.RED);
        if (state != null)
            drawTerritories(g2d);
        g2d.dispose();
    }

    public void paintOutlines(Graphics2D g) {
        drawOutline(g, mapGraphics.shapeNorthAmericaOutline, 9, 41);
        drawOutline(g, mapGraphics.shapeGreenlandOutline, 272, 12);
        drawOutline(g, mapGraphics.shapeSouthAmericaOutline, 97, 320);
        drawOutline(g, mapGraphics.shapeBritainOutline, 349, 128);
        drawOutline(g, mapGraphics.shapeIcelandOutline, 392, 80);
        drawOutline(g, mapGraphics.shapeEuropeOutline, 372, 61);
        drawOutline(g, mapGraphics.shapeAsiaOutline, 534, 10);
        drawOutline(g, mapGraphics.shapeJapanOutline, 934, 140);
        drawOutline(g, mapGraphics.shapeAfricaOutline, 362, 301);
        drawOutline(g, mapGraphics.shapeMadagascarOutline, 629, 523);
        drawOutline(g, mapGraphics.shapeIndonesiaOutline, 775, 412);
        drawOutline(g, mapGraphics.shapeNewGuineaOutline, 939, 408);
        drawOutline(g, mapGraphics.shapeOceaniaOutline, 868, 497);
    }

}
