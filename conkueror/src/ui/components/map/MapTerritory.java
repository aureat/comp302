package ui.components.map;

import domain.mapstate.TerritoryState;
import domain.player.Colors;
import ui.graphics.map.MapGraphicsDefault;
import ui.service.MapController;
import ui.assets.Fonts;
import ui.graphics.color.ColorGraphics;
import ui.graphics.color.Palette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MapTerritory extends JButton implements MouseListener, MouseMotionListener {

    private final TerritoryState state;
    private final boolean isBuildMode;

    private JLabel label;
    private final Shape shape;
    private boolean isHovered = false;
    private boolean isSelected = false;
    private final int width, height;

    public MapTerritory(TerritoryState state, Shape shape, int x, int y) {
        // set properties
        this.state = state;
        this.shape = shape;
        this.width = (int) shape.getBounds().getWidth();
        this.height = (int) shape.getBounds().getHeight();

        // get state properties
        isBuildMode = MapController.get().getMode() == MapController.Mode.Build;

        // initialize component
        initComponent();
        initLabel();
    }

    public void initComponent() {
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setMixingCutoutShape(shape);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void initLabel() {
        // do not add label if territory should not be playable
        if (isBuildMode || isDisabled())
            return;

        // construct label
        label = new JLabel("0");
        label.setFont(Fonts.GilroyExtraBold.deriveFont(25f));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setForeground(Color.WHITE);
        label.setBounds((width - 50) / 2, (height - 30) / 2, 50, 30);
        label.addMouseListener(this);
        label.addMouseMotionListener(this);
        add(label);
    }

    public boolean isPlayable() {
        return state.isPlayable();
    }

    public boolean isDisabled() {
        return !state.isPlayable();
    }

    public TerritoryState getState() {
        return state;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
        repaint();
    }

    public void toggleSelected() {
        isSelected = !isSelected;
        repaint();
    }

    public Palette getPalette() {
        if (isBuildMode || isDisabled())
            return ColorGraphics.getPalette(Colors.ColorType.Gray);
        return ColorGraphics.getPalette(state.getOwner().getColor());
    }

    public void update() {
        if (label != null)
            label.setText(String.valueOf(state.getArmies()));
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) shape.getBounds().getWidth(), (int) shape.getBounds().getHeight());
    }

    public Color getFillColor() {
        Palette palette = getPalette();
        if (isSelected) {
            if (isHovered) {
                return palette.territoryFillSelectedHover;
            } else {
                return palette.territoryFillSelect;
            }
        } else {
            if (isHovered) {
                return palette.territoryFillHover;
            } else {
                return palette.territoryFill;
            }
        }
    }

    public Color getStrokeColor() {
        return getPalette().territoryStroke;
    }

    @Override
    public boolean contains(Point p) {
        return shape.contains(p);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        if (contains(e.getPoint())) {
            isHovered = true;
            repaint();
        } else {
            isHovered = false;
            repaint();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (contains(e.getPoint())) {
            isHovered = true;
            repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        isHovered = false;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        MapController.get().handleMapTerritoryClick(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(MapGraphicsDefault.territoryStroke));
        g2d.setColor(getStrokeColor());
        g2d.draw(shape);
        g2d.setColor(getFillColor());
        g2d.fill(shape);
        g2d.dispose();
        super.paintComponent(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

}
