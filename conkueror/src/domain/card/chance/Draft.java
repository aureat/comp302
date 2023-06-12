package domain.card.chance;

import domain.card.ArmyCard;
import domain.card.Card;
import domain.game.Game;
import domain.game.config.GameConfig;
import domain.mapstate.TerritoryState;

public class Draft implements ChanceEffect {

    @Override
    public void applyEffect() {
        // TODO: Implement
        //terr to add armies
        TerritoryState terr = Game.getInstance().getMapState().getTerritoryState("Alaska");
        //Card card = new ArmyCard();
        int cardTradeResult = GameConfig.get().getArmyCardTradeResult(Game.getInstance().getCurrentPlayer().getArmyCards());
        terr.setArmies(terr.getArmies()+cardTradeResult);
    }

}
