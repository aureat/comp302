package ui.app.router;

import ui.app.Context;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.util.SwingUtils;
import util.ClassUtils;

import javax.swing.*;
import java.awt.*;

/**
 * View Panel is where the UI is rendered and displayed.
 * ViewPanel must be annotated with {@link View} to be registered in the router.
 * ViewPanel requires a ViewController annotated with {@link ui.app.router.Controller}.
 *
 * @param <Controller> the controller type associated with this view
 * @see Router
 * @since 0.4.0
 */
public abstract class ViewPanel<Controller extends ViewController> extends JPanel {

    private Class<Controller> controllerType;
    private Controller controller;
    private Route route;

    public boolean isInitialized = false;

    /**
     * Asset for the background image for this view.
     */
    private Asset background;

    public ViewPanel() {
        setLayout(new BorderLayout());
    }

    /**
     * API for initializing the view.
     */
    public void init() {
        if (isInitialized) {
            return;
        }
        initialize();
        isInitialized = true;
    }

    /**
     * Gets the controller type as declared in the ViewPanel as a type parameter.
     * @return {@link ViewController} class associated with this ViewPanel
     */
    public Class<Controller> getControllerType() {
        return controllerType;
    }

    public void setControllerType(Class<ViewController> controllerType) {
        this.controllerType = (Class<Controller>) controllerType;
    }

    /**
     * Method for getting the controller associated with this view.
     * @return {@link ViewController} for this view
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Method for getting the controller associated with this view.
     * @return {@link ViewController} for this view
     */
    public Controller createController() {
        if (controller != null) {
            return controller;
        }
        try {
            System.out.println("Creating controller in view panel for " + this);
            controller = ClassUtils.newInstance(controllerType);
            controller.setRoute(route);
            controller.initialize();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return controller;
    }

    /**
     * Method for getting the route associated with this view.
     * @return {@link Route} object
     */
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    /**
     * API for setting the background image of the view.
     * Loads the asset if it is not already loaded.
     * @param bg the background asset
     * @see Asset
     * @see Assets#Background
     */
    public void setViewBackground(Asset bg) {
        background = bg;
        background.load();
    }

    /**
     * API for painting the view.
     * Draws background image if it exists.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            Graphics2D g2 = SwingUtils.setQualityGraphics2D(g);
            Image bgImage = background.getImage();
            g2.drawImage(bgImage, 0, 0, getContainerWidth(), getContainerHeight(), null);
            g2.dispose();
        }
    }

    /**
     * API for getting the preferred size of the view.
     * @return dimension for the JPanel
     */
    @Override
    public Dimension getPreferredSize() {
        return getContainerSize();
    }

    /**
     * API for updating the view.
     * @see ViewController
     * @see Router
     */
    public void updateView() {
        revalidate();
        repaint();
        onUpdate();
        System.out.println("Updated view " + this.getClass().getSimpleName());
    }

    /**
     * API for rebuilding the view.
     * @see ViewController
     * @see Router
     */
    public void rebuildView() {
        removeAll();
        initialize();
        onUpdate();
        System.out.println("Rebuilt view " + this.getClass().getSimpleName());
    }

    public void setSizeOnCenter(Container container, Dimension dimension) {
        setSizeOnCenter(container, dimension.width, dimension.height);
    }

    public void setSizeOnCenter(Container container) {
        setSizeOnCenter(container, container.getPreferredSize());
    }

    public void setSizeOnCenter(Container container, int width, int height) {
        int x = (getWidth() - width) / 2;
        int y = (getHeight() - height) / 2;
        container.setBounds(x, y, width, height);
    }

    /**
     * Method for getting the owner of the router.
     * @see Router
     * @return the container that this view is mounted on
     */
    public Container getContainer() {
        return Context.get().getRouter().getContainer();
    }

    /**
     * API for getting the size of the container.
     * @return dimension of the container
     */
    public Dimension getContainerSize() {
        return getContainer().getSize();
    }

    /**
     * API for getting the width of the container.
     * @return width of the container
     */
    public int getContainerWidth() {
        return getContainer().getWidth();
    }

    /**
     * API for getting the height of the container.
     * @return height of the container
     */
    public int getContainerHeight() {
        return getContainer().getHeight();
    }

    /**
     * API for getting the panel that this view builds.
     * @see Router
     * @return the panel that this view builds
     */
    public Container getPanel() {
        return this;
    }


    /**
     * Hook for initializing the view.
     * @see Route
     * @see Router
     */
    public abstract void initialize();

    /**
     * Hook for preloading heavy assets.
     */
    public void preload() {}

    /**
     * Hook called when the view is updated.
     * @see Router
     */
    public void onUpdate() {}

    /**
     * Hook called when the view is mounted on the container.
     * @see Router
     */
    public void onMount() {}

}