package app.router;

import java.awt.*;

public class Router {

    private Container owner;
    private Container defaultContainer;

    public Router(Container owner) {
        this.owner = owner;
    }

    public void setOwner(Container owner) {
        this.owner = owner;
    }

    public void setDefaultContainer(Container defaultContainer) {
        this.defaultContainer = defaultContainer;
    }

}
