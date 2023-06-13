package domain.card.chance;

import domain.game.Dice;
import domain.game.Game;
import domain.mapstate.TerritoryState;

import java.io.Serializable;
import java.util.Random;

public class Reinforcements implements ChanceEffect, Serializable {

    @Override
    public void applyEffect() {
        TerritoryState terr = Game.getInstance().reinforcementsTo;
        int dicaval = new Random().nextInt(6) + 1;
        int initialarmy= terr.getArmies();
        terr.setArmies(initialarmy+dicaval);
        Game.getInstance().reinforcementsTo = null;
    }

}
