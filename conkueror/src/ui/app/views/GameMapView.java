package ui.app.views;

import ui.app.Context;
import ui.app.router.Route;
import ui.app.controllers.GameMapController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.core.ImageBtnStack;


@View(at = Route.GameMap)
public class GameMapView extends ViewPanel<GameMapController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets buttons = Assets.MenuMd;
    private final Assets cards = Assets.PanelContext;

    public GameMapView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("map");
        buttons.loadAsset("pause");
        buttons.loadAsset("help");
        buttons.loadAsset("cards");

        cards.loadAsset("army");
        cards.loadAsset("territory");
        cards.loadAsset("effect");
    }

    public void initialize() {

        Assets backgrounds = Assets.Background;

        // Set Background
        setViewBackground(backgrounds.getAsset("map"));

        // Button Stack
        ImageBtnStack stack1 = new ImageBtnStack(ImageBtnStack.VERTICAL, 48, 50, 22, 20);
        stack1.addButton(buttons.getAsset("pause"))
                .addActionListener(e -> getController().redirect(Route.Pause));
        stack1.addButton(buttons.getAsset("help"))
                .addActionListener(e -> getController().redirect(Route.Help));
        stack1.addButton(buttons.getAsset("cards"))
                .addActionListener(e -> System.exit(0));

        // place the stack in the panel
        stack1.setBounds(
                30,
                30,
                stack1.getPreferredSize().width,
                stack1.getPreferredSize().height
        );

        add(stack1);

        // Card Stack
        ImageBtnStack stack2 = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 37, 49, 22, 20);
        stack2.addButton(cards.getAsset("army"))
                .addActionListener(e -> getController().redirect(Route.Pause));
        stack2.addButton(cards.getAsset("territory"))
                .addActionListener(e -> getController().redirect(Route.Help));
        stack2.addButton(cards.getAsset("effect"))
                .addActionListener(e -> System.exit(0));

        // place stack in the panel
        stack2.setBounds(
                30,
                getContainerHeight()-67,
                stack2.getPreferredSize().width,
                stack2.getPreferredSize().height
        );

        add(stack2);

    }

}

