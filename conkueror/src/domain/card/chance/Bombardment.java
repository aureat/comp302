package domain.card.chance;

import domain.game.Dice;
import domain.game.Game;
import domain.mapstate.TerritoryState;

public class Bombardment implements ChanceEffect {

    @Override
    public void applyEffect() {
        // TODO: Implement
//        // territory to attack from
//        TerritoryState terr = Game.getInstance().getMapState().getTerritoryState("Alaska");
//        //territory to attack to
//        TerritoryState terr2 = Game.getInstance().getMapState().getTerritoryState("North West");

        Dice dice = new Dice();
        int diceval = 0;
        int firstdice = dice.rollAttacker();
        int seconddice = dice.rollAttacker();
        if (firstdice>seconddice)  diceval=firstdice;
        else diceval=seconddice;
    }

}
