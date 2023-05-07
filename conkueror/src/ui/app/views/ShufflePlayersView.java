package ui.app.views;

import domain.player.Player;
import ui.app.controllers.PlayersController;
import ui.app.controllers.ShufflePlayersController;
import ui.app.router.Route;
import ui.app.router.View;
import ui.app.router.ViewPanel;
import ui.assets.Assets;
import ui.components.core.ImageBtnStack;
import ui.components.player.PlayerPreview;

import javax.swing.*;
import java.awt.*;

@View(at = Route.ShufflePlayers)
public class ShufflePlayersView extends ViewPanel<ShufflePlayersController> {

    private JPanel players;

    public ShufflePlayersView() {
        setLayout(null);
    }

    @Override
    public void preload() {
        Assets.Background.loadAsset("sunburst-logo-md");
        Assets.ButtonLg.loadAsset("shuffle");
        Assets.ButtonLg.loadAsset("continue");
    }

    public void createPreview(Player player) {
        PlayerPreview preview = new PlayerPreview(player);
        preview.setCursor(Cursor.getDefaultCursor());
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
        setViewBackground(Assets.Background.getAsset("sunburst-logo-md"));

        players = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 0));
        getController().getPlayers().forEach(this::createPreview);

        players.setOpaque(false);

        add(players);

        ImageBtnStack stack = new ImageBtnStack(ImageBtnStack.HORIZONTAL, 325, 59, 50, 30);
        stack.addButton(Assets.ButtonLg.getAsset("shuffle"))
                .addActionListener(e -> {
                    getController().shufflePlayers();
                    players.removeAll();
                    getController().getPlayers().forEach(this::createPreview);
                    players.revalidate();
                    players.repaint();
                });
        stack.addButton(Assets.ButtonLg.getAsset("continue"))
                .addActionListener(e -> getController().redirect(Route.Map));

        stack.setBounds(
                (getWidth() - stack.getPreferredSize().width) / 2,
                getHeight() - stack.getPreferredSize().height - 50,
                stack.getPreferredSize().width,
                stack.getPreferredSize().height
        );

        add(stack);
    }

}
