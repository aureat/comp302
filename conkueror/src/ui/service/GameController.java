package ui.service;

import domain.game.Game;
import domain.game.Phase;
import domain.player.Player;
import ui.app.views.GameMapView;
import ui.assets.Assets;
import ui.components.core.AssetRenderer;

import javax.swing.*;

public class GameController {

    private static class GameControllerContainer {
        private static GameController instance;
    }

    public static GameController getInstance() {
        if (GameControllerContainer.instance == null) {
            GameControllerContainer.instance = new GameController();
        }
        return GameControllerContainer.instance;
    }

    private GameMapView view;
    private Game game = Game.getInstance();

    private GameController() {

    }

    public void setView(GameMapView view) {
        this.view = view;
    }

    public void updatePhasePanel() {
        if (game.getPhase() == null) {
            return;
        }

        if (Game.getInstance().getPhase() == Phase.Attack) {
            view.attackLabel.setVisible(true);
            view.fortifyLabel.setVisible(false);
            view.draftLabel.setVisible(false);
        } else if (Game.getInstance().getPhase() == Phase.Fortify) {
            view.fortifyLabel.setVisible(true);
            view.attackLabel.setVisible(false);
            view.draftLabel.setVisible(false);
        } else if (Game.getInstance().getPhase() == Phase.Draft) {
            view.draftLabel.setVisible(true);
            view.attackLabel.setVisible(false);
            view.fortifyLabel.setVisible(false);
            if (Game.getInstance().getDraftArmies() > 0) {
                view.draftButtons.get(Game.getInstance().getDraftArmies() - 1).setVisible(true);
            } else {
                view.draftButtons.forEach(button -> button.setVisible(false));
            }
        }

        view.nextButton.setVisible(game.canGoToNextPhase());

        Player player = game.getCurrentPlayer();
        System.out.println(player.getFullName());

        ImageIcon colorF = Assets.ColorFrame.getAsset(player.getColor().toString().toLowerCase()).getImageIcon(70,70);
        view.colorLabel.setIcon(colorF);
        view.colorLabel.setBounds(0,0,70,70);
        ImageIcon avatarR = Assets.AvatarCircular.getAsset(player.getAvatar().toString().toLowerCase()).getImageIcon(70,70);
        view.avatarLabel.setIcon(avatarR);
        view.avatarLabel.setBounds(5,0,70,70);
        view.avatarLabel.add(view.colorLabel);
        view.phaseLabel.add(view.avatarLabel);

    }

    public void updateContextPanel() {
        Player player = game.getCurrentPlayer();
        if (player.canApplyArmyCards()) {
            view.armyButton.setVisible(true);
        }
        if (player.canApplyTerritoryCards()) {
            view.territoryButton.setVisible(true);
        }
        if (game.canApplyChanceCard()) {
            view.effectButton.setVisible(true);
        }
    }

    public void setComputerTurn() {

    }

    public void applyArmyCard() {
        game.applyArmyCard();
        view.armyButton.setVisible(false);
    }

    public void applyTerritoryCard() {
        game.applyTerritoryCard();
        view.territoryButton.setVisible(false);
    }

    public void applyEffectCard() {
        game.applyChanceCard();
        view.effectButton.setVisible(false);
    }

}
