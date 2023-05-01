package ui.components.map.defaultMap;

import ui.components.map.Territory;
import ui.graphics.MapGraphics;

import javax.swing.*;
import java.awt.*;

public class NorthAmerica extends JPanel {

    private Shape outline;

    private Shape shapeAlaska;
    private Shape shapeNorthwest;
    private Shape shapeAlberta;
    private Shape shapeOntario;

    private Territory alaska;
    private Territory northwest;
    private Territory alberta;
    private Territory ontario;

    public NorthAmerica() {
        initComponent();
    }

    @SuppressWarnings("unchecked")
    public void initComponent() {

        setLayout(null);
        setSize(590, 485);

        shapeAlaska = MapGraphics.createAlaska();
        shapeNorthwest = MapGraphics.createNorthwest();
        shapeAlberta = MapGraphics.createAlberta();
        shapeOntario = MapGraphics.createOntario();

        alaska = new Territory(shapeAlaska);
        northwest = new Territory(shapeNorthwest);
        alberta = new Territory(shapeAlberta);
        ontario = new Territory(shapeOntario);

        alaska.setBounds(9, 64, 114, 112);
        northwest.setBounds(110, 45, 245, 85);
        alberta.setBounds(110, 127, 137, 85);
        ontario.setBounds(219, 130, 112, 120);

        add(alaska);
        add(northwest);
        add(alberta);
        add(ontario);

    }

}
