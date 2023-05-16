package ui.app.views;

import domain.player.Player;
import ui.app.controllers.PlayersController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Asset;
import ui.assets.Assets;
import ui.components.animated.AnimatedBurst;
import ui.components.core.ImageBtnStack;
import ui.components.core.RoundedImage;
import ui.components.player.PlayerPreview;

import javax.swing.*;
import java.awt.*;

@View(at = Route.Players)
public class PlayersView extends ViewPanel<PlayersController> {

    private JPanel players;

    public PlayersView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("sunburst-logo-md");
        Assets.ButtonLg.loadAsset("add-player");
        Assets.ButtonLg.loadAsset("continue");
    }

    public void createPreview(Player player) {
        PlayerPreview preview = new PlayerPreview(player);
        preview.addActionListener(e -> getController().editPlayer(player));
        getController().addPreview(preview);
        players.add(preview);
        players.setBounds(
                (getWidth() - players.getPreferredSize().width) / 2,
                (getHeight() - players.getPreferredSize().height) / 2,
                players.getPreferredSize().width,
                players.getPreferredSize().height
        );
    }

    public void initialize() {

        // background
        setViewBackground(Assets.Background.getAsset("sunburst"));

        // background burst animation
        AnimatedBurst burst = new AnimatedBurst(AnimatedBurst.LG);
        setSizeOnCenter(burst);

        // logo
        ImageIcon logo = Assets.Logo.getAsset("conkueror").getImageIcon(690, 110);
        JLabel logoLabel = new JLabel(logo);
        logoLabel.setBounds(
                (getWidth() - logo.getIconWidth()) / 2,
                60,
                logo.getIconWidth(),
                logo.getIconHeight()
        );

        // players
        players = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        getController().getPlayers().forEach(this::createPreview);
        players.setOpaque(false);

        ImageBtnStack stack = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 325, 59, 50, 30);
        stack.addButton(Assets.ButtonLg.getAsset("add-player"))
                .addActionListener(e -> {
                    Player player = getController().addPlayer();
                    if (player != null) {
                        createPreview(getController().getPlayers().get(getController().getPlayersCount() - 1));
                        getController().update();
                    }
                });
        stack.addButton(Assets.ButtonLg.getAsset("continue"))
                .addActionListener(e -> getController().redirect(Route.ShufflePlayers));

        stack.setBounds(
                (getWidth() - stack.getPreferredSize().width) / 2,
                getHeight() - stack.getPreferredSize().height - 50,
                stack.getPreferredSize().width,
                stack.getPreferredSize().height
        );

        add(burst);
        add(logoLabel);
        add(players);
        add(stack);

        setComponentZOrder(logoLabel, 0);
        setComponentZOrder(players, 1);
        setComponentZOrder(stack, 2);
    }

}
