package ui.app.views;

import ui.app.Context;
import ui.app.router.Route;
import ui.app.controllers.MainController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.core.ImageBtnStack;


@View(at = Route.Main)
public class MainView extends ViewPanel<MainController> {

    private final Assets backgrounds = Assets.Background;
    private final Assets buttons = Assets.ButtonLg;

    public MainView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        backgrounds.loadAsset("main");
        buttons.loadAsset("new-game");
        buttons.loadAsset("continue-game");
        buttons.loadAsset("exit");
    }

    public void initialize() {

        Assets backgrounds = Assets.Background;
        Assets buttons = Assets.ButtonLg;

        // Set Background
        setViewBackground(backgrounds.getAsset("main"));

        // Button Stack
        ImageBtnStack stack = new ImageBtnStack(ImageBtnStack.VERTICAL, 325, 59, 15, 30);
        stack.addButton(buttons.getAsset("new-game"))
                .addActionListener(e -> getController().redirect(Route.Players));
        stack.addButton(buttons.getAsset("continue-game"))
                .addActionListener(e -> Context.get().getSystemActions().openNotImplemented());
        stack.addButton(buttons.getAsset("exit"))
                .addActionListener(e -> System.exit(0));

        // center the stack in the panel
        stack.setBounds(
                (getWidth() - stack.getPreferredSize().width) / 2,
                (getHeight() - stack.getPreferredSize().height) / 2 + 50,
                stack.getPreferredSize().width,
                stack.getPreferredSize().height
        );

        add(stack);

    }

}
