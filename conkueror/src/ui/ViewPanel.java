package ui;

import app.router.Router;
import app.router.RouterRedirect;
import assets.Assets;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public abstract class ViewPanel extends JPanel implements RouterRedirect {

    private Router router;
    private String name;
    private boolean cacheable;
    private boolean isDefault;

    public ViewPanel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCacheable() {
        return cacheable;
    }

    public void setCacheable(boolean cacheable) {
        this.cacheable = cacheable;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }

    public Container getContainer() {
        return router.getContainer();
    }

    public Dimension getContainerSize() {
        return router.getContainer().getSize();
    }

    public int getContainerWidth() {
        return router.getContainer().getWidth();
    }

    public int getContainerHeight() {
        return router.getContainer().getHeight();
    }

    public void setBackground(Assets.Background background) {
        add(new JLabel(background.getImageIcon(getContainerWidth(), getContainerHeight() - 39)));
    }

    public void redirect(String name, Object... args) {
        try {
            router.redirect(name, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateView() {
        repaint();
        onUpdate();
    }

    /* Hooks */
    public abstract void initialize();
    public void onUpdate() {}
    public void onMount() {}

}