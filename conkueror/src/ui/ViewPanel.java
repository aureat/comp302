package ui;

import app.router.Router;
import app.router.RouterRedirect;

import javax.swing.*;

@SuppressWarnings("serial")
public abstract class ViewPanel extends JPanel implements RouterRedirect {

    private Router router;
    private String name;
    private boolean cacheable;
    private boolean isDefault;

    public ViewPanel() {}

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

    public void redirect(String name, Object... args) {
        router.redirect(name, args);
    }

    public void redirect(String name) {
        router.redirect(name);
    }

}