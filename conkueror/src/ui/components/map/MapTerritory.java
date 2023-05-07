package ui.components.map;

import domain.game.Game;
import domain.game.Phase;
import domain.mapstate.TerritoryState;
import domain.player.Colors;
import domain.player.Player;
import ui.app.Context;
import ui.app.router.Route;
import ui.app.views.GameMapView;
import ui.assets.Fonts;
import ui.graphics.color.ColorGraphics;
import ui.graphics.color.Palette;
import util.ClassUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MapTerritory extends JButton implements MouseListener, MouseMotionListener {

    private final TerritoryState state;
    private final Shape shape;
    private boolean isHovered = false;
    private boolean isSelected = false;
    private final int x, y;

    private boolean isBuildMode = false;

    private JLabel label;

    private boolean isPlayable;

    public MapTerritory(TerritoryState state, Shape shape, int x, int y) {
        this.state = state;
        this.shape = shape;
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        this.x = x;
        this.y = y;
        int width = (int) shape.getBounds().getWidth();
        int height = (int) shape.getBounds().getHeight();
        setPreferredSize(new Dimension(width, height));
        setLayout(null);
        isPlayable = state.isPlayable();
        label = new JLabel("0");
        label.setFont(Fonts.GilroyExtraBold.deriveFont(25f));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setBounds(width/2, height/2, 30, 30);
        if (isPlayable)
            add(label);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void setBuildMode() {
        this.isBuildMode = true;
        this.isSelected = true;
        label.setVisible(false);
    }

    public boolean isBuildMode() {
        return isBuildMode;
    }

    public TerritoryState getState() {
        return state;
    }

    public Shape getShape() {
        return shape;
    }

    public boolean isHovered() {
        return isHovered;
    }

    public void setHovered(boolean hovered) {
        isHovered = hovered;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public Palette getPalette() {
        if (isBuildMode)
            return ColorGraphics.getPalette(Colors.ColorType.Blue);
        if (!isPlayable)
            return ColorGraphics.getPalette(Colors.ColorType.Gray);
        return ColorGraphics.getPalette(state.getOwner().getColor());
    }

    public void update() {
        label.setText(String.valueOf(state.getArmies()));
        repaint();
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int) shape.getBounds().getWidth(), (int) shape.getBounds().getHeight());
    }

    public Color getFillColor() {
        if (isBuildMode || isPlayable) {
            if (isSelected) {
                if (isHovered) {
                    return getPalette().territoryFillSelectedHover;
                } else {
                    return getPalette().territoryFillSelect;
                }
            } else {
                if (isHovered) {
                    return getPalette().territoryFillHover;
                } else {
                    return getPalette().territoryFill;
                }
            }
        } else {
            return getPalette().territoryFill;
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
        if (!isBuildMode && isPlayable) {
            if (contains(e.getPoint())) {
                isHovered = true;
                repaint();
            } else {
                isHovered = false;
                repaint();
            }
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
        if (!isBuildMode && isPlayable) {
            if (Game.getInstance().getPhase() == Phase.Draft){
                Game.getInstance().setDraftArmies(state);
                Route.GameMap.getController().update();
                update();
            } else if (Game.getInstance().getPhase() == Phase.Attack) {

            } else if (Game.getInstance().getPhase() == Phase.Fortify) {

            }
        }
        if (isBuildMode) {
            if (contains(e.getPoint())) {
                setSelected(!isSelected);
                state.setPlayable(isSelected);
                repaint();
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(new BasicStroke(8));
        g2d.setColor(getStrokeColor());
        g2d.draw(shape);
        g2d.setColor(getFillColor());
        g2d.fill(shape);
        super.paintComponent(g);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

}
