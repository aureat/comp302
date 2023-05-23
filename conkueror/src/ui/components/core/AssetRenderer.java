package ui.components.core;

import org.jetbrains.annotations.Range;
import ui.assets.Asset;
import ui.util.SwingUtils;

import javax.swing.*;
import java.awt.*;

/**
 * AssetRenderer is a component that renders an {@link Asset}.
 *
 * <p>
 *  Rendering Hints:
 *  <ul>
 *      <li>Set {@code renderType=AssetRenderer.RENDER_QUALITY} for prioritizing quality</li>
 *      <li>Set {@code renderType=AssetRenderer.RENDER_SPEED} for prioritizing speed</li>
 *  </ul>
 * </p>
 *
 * @since 0.5.5
 */
public class AssetRenderer extends JComponent {

    public enum RenderType {
        QUALITY, SPEED
    }

    private Image image;
    private int width;
    private int height;

    private RenderType renderType = RenderType.QUALITY;

    public AssetRenderer(Asset asset, int width, int height) {
        this(asset.getImage(), width, height);
    }

    public AssetRenderer(Asset asset) {
        this(asset.getImage(), asset.getWidth(), asset.getHeight());
    }

    private AssetRenderer(Image image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
        setSize(width, height);
        setOpaque(false);
        setVisible(true);
    }

    public void setAsset(Asset asset) {
        setAsset(asset.getImage(), asset.getWidth(), asset.getHeight());
    }

    public void setAsset(Asset asset, int width, int height) {
        setAsset(asset.getImage(), width, height);
    }

    private void setAsset(Image image, int width, int height) {
        this.image = image;
        this.width = width;
        this.height = height;
        setSize(width, height);
        repaint();
    }

    public void setRenderType() {
        setRenderType(RenderType.QUALITY);
    }

    public void setRenderType(RenderType renderType) {
        this.renderType = renderType;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = renderType == RenderType.QUALITY
                    ? SwingUtils.setQualityGraphics2D((Graphics2D) g.create())
                    : SwingUtils.setFastGraphics2D((Graphics2D) g.create());
        g2d.drawImage(image, 0, 0, this);
        g2d.dispose();
    }

}
