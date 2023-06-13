package ui.service;

import domain.card.ChanceCard;
import domain.card.chance.EffectType;
import domain.game.Game;
import domain.game.Phase;
import domain.player.Player;
import ui.app.Context;
import ui.app.router.Route;
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

    private boolean chanceCardMode = false;
    private boolean armyCardMode = false;
    private EffectType selectedEffect;

    private GameController() {

    }

    public void setView(GameMapView view) {
        this.view = view;
    }

    public void setChanceCardMode(boolean chanceCardMode) {
        this.chanceCardMode = chanceCardMode;
    }

    public boolean isChanceCardMode() {
        return chanceCardMode;
    }

    public void setArmyCardMode(boolean armyCardMode) {
        this.armyCardMode = armyCardMode;
    }

    public boolean isArmyCardMode() {
        return armyCardMode;
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
        view.armyButton.setVisible(player.canApplyArmyCards());
        view.territoryButton.setVisible(player.canApplyTerritoryCards());
        view.effectButton.setVisible(game.canApplyChanceCard() && !game.getGameState().getCurrentChanceCard().isUsed());
    }

    public void setComputerTurn() {

    }

    public void applyArmyCard() {
        setArmyCardMode(true);
        view.cardName.setText("Armies");
        view.armyButton.setVisible(false);
    }

    public void applyTerritoryCard() {
        game.applyTerritoryCard();
        view.territoryButton.setVisible(false);
    }

    public void applyEffectCard() {
        ChanceCard card = game.getCurrentChanceCard();
        if (card.getEffect() == EffectType.Revolt ||
                card.getEffect() == EffectType.Reinforcements ||
                card.getEffect() == EffectType.NuclearStrike) {
            setChanceCardMode(true);
        }
        view.cardName.setText(card.getName());
        view.effectButton.setVisible(false);
    }

    public void endEffectCard() {
        setChanceCardMode(false);
        view.effectButton.setVisible(false);
        view.cardName.setText("");
    }

    public void endArmyCard() {
        setArmyCardMode(false);
        view.armyButton.setVisible(false);
        view.cardName.setText("");
    }

}
