package domain.card.chance;

import domain.game.Dice;
import domain.game.Game;
import domain.mapstate.TerritoryState;

public class Reinforcements implements ChanceEffect {

    @Override
    public void applyEffect() {
        //terr to add arrmy
        TerritoryState terr = Game.getInstance().getMapState().getTerritoryState("Alaska");
        Dice dice = new Dice();
        int dicaval = dice.rollAttacker();
        int initialarmy= terr.getArmies();
        terr.setArmies(initialarmy+dicaval);
    }

}
