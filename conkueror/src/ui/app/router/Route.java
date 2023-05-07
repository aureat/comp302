package ui.app.router;

import util.ClassUtils;

/**
 * Contains all the routes for the application.
 * Route.None is used for service controllers.
 *
 * @since 0.4.0
 * @see Router
 * @see View
 * @see Controller
 */
public enum Route {
    Main(true),

    /** Screen for adding players to the game */
    Players,

    /** Screen for editing players */
    EditPlayer,

    /** Screen for choosing a map */
    ChooseMap,

    /** Screen for configuring the map */
    BuildMap(),

    /** Screen for deciding who goes first */
    ShufflePlayers,

    /** Loading screen before the game starts */
    Loading,

    /** Screen for playing the game */
    Map(),

    /** Screen where the chance card is shown */
    ChanceCard,

    /** Screen where the player can trade army cards */
    ArmyBonus,

    /** Screen where the player can trade territory cards */
    TerritoryBonus,

    /** Screen where the player can see their cards */
    Inventory,

    /** Screen where the player can pause the game and see the leaderboard */
    Pause(),

    /** Screen where the player can get help */
    Help;


    /*
     * The following fields are used to cache the view and controller instances
     */
    private Class<? extends ViewPanel<? extends ViewController>> viewType;
    private ViewPanel<? extends ViewController> view;
    private ViewController controller;
    private final boolean isDefault;

    Route() {
        this(false);
    }

    Route(boolean isDefault) {
        this.isDefault = isDefault;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setViewType(Class<? extends ViewPanel<? extends ViewController>> viewType) {
        this.viewType = viewType;
    }

    public void setControllerType(Class<ViewController> controllerType) {
        this.view.setControllerType(controllerType);
    }

    public ViewPanel createView() {
        try {
            if (view == null) {
                view = ClassUtils.newInstance(viewType);
                view.setRoute(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return view;
    }

    public ViewController createController() {
        if (controller == null) {
            controller = view.createController();
        }
        return controller;
    }

    public ViewPanel<? extends ViewController> getView() {
        if (view == null) {
            createView();
        }
        view.init();
        return view;
    }

    public void preloadView() {
        view.preload();
    }

    public ViewController getController(Object... args) {
        if (controller == null) {
            createController();
        }
        if (args.length > 0) {
            System.out.println("Calling onRoute for " + controller.getClass());
            try {
                ClassUtils.invokeMethod(controller, "onRoute", args);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return controller;
    }

    public void setRoute(Router router, Object... args) {
        router.setCurrentRoute(this);
        ViewController controller = getController(args);
        controller.update();
        controller.onMount();
        router.replaceContainer(view);
        ViewPanel<? extends ViewController> view = getView();
        view.onMount();
    }

    public void update() {
        controller.update();
    }

    public void rebuild() {
        view.rebuildView();
    }

}
