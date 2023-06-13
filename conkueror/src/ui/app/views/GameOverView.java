package ui.app.views;

import ui.app.Context;
import ui.app.controllers.GameOverController;
import ui.app.controllers.MainController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.animated.AnimatedBurst;
import ui.components.core.AssetRenderer;
import ui.components.core.ImageBtnStack;
import ui.components.core.ImageButton;

import javax.swing.*;


@View(at = Route.GameOver)
public class GameOverView extends ViewPanel<GameOverController> {

    public GameOverView() {
        setLayout(null);
    }

    @Override
    public void preload() {

    }

    public void initialize() {

        Assets buttons = Assets.ButtonLg;

        // background
        setViewBackground(Assets.Background.getAsset("sunburst"));

        // background burst animation
        AnimatedBurst burst = new AnimatedBurst(AnimatedBurst.LG);
        centerComponent(burst);

        // logo
        AssetRenderer gameOver = new AssetRenderer(Assets.GameOver.getAsset("gameover"));
        centerComponentWithOffset(gameOver, 0, -100);

        ImageButton quitButton = new ImageButton(Assets.ButtonLg.getAsset("quit-game").getImageIcon(), 40, 40);
        quitButton.addActionListener(e -> System.exit(0));
        quitButton.setBounds(
                (getContainerWidth() - quitButton.getPreferredSize().width) / 2,
                getContainerHeight() - quitButton.getPreferredSize().height - 240,
                quitButton.getPreferredSize().width,
                quitButton.getPreferredSize().height
        );
        add(quitButton);

        // add components
        add(burst);
        add(gameOver);
        add(quitButton);

        setComponentZOrder(quitButton, 0);
        setComponentZOrder(gameOver, 1);
        setComponentZOrder(burst, 2);

    }

}
