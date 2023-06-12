package ui.app.views;

import ui.app.Context;
import ui.app.router.Route;
import ui.app.controllers.MainController;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.components.core.AssetRenderer;
import ui.components.core.ImageBtnStack;

import javax.swing.*;


@View(at = Route.Main)
public class MainView extends ViewPanel<MainController> {

    public MainView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("main");
        Assets.LogoSlogan.loadAsset("conkueror-slogan");
        Assets.DevLogo.loadAsset("nerd5");
        Assets.ButtonLg.loadAsset("new-game");
        Assets.ButtonLg.loadAsset("continue-game");
        Assets.ButtonLg.loadAsset("exit");

    }

    public void initialize() {

        Assets buttons = Assets.ButtonLg;

        // Set Background
        setViewBackground(Assets.Background.getAsset("main"));

        // Logo
        AssetRenderer logo = new AssetRenderer(Assets.LogoSlogan.getAsset("conkueror-slogan"));
        centerComponentWithOffset(logo, 0, -200);

        // Developer Logo
        AssetRenderer devLogo = new AssetRenderer(Assets.DevLogo.getAsset("nerd5"));
        positionSouthWest(devLogo, 30, 30);

        // Button Stack
        ImageBtnStack stack = new ImageBtnStack(ImageBtnStack.VERTICAL, 325, 59, 15, 30);
        stack.addButton(buttons.getAsset("new-game"))
                .addActionListener(e -> getController().newGame());
        stack.addButton(buttons.getAsset("continue-game"))
                .addActionListener(e -> Context.get().getSystemActions().openNotImplemented());
        stack.addButton(buttons.getAsset("exit"))
                .addActionListener(e -> System.exit(0));
        centerComponentWithOffset(stack, 0, 50);

        // add components
        add(logo);
        add(devLogo);
        add(stack);

    }

}
