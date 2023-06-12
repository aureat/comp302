package domain.card.chance;

import domain.game.Game;
import domain.mapstate.TerritoryState;

public class Revolt implements ChanceEffect {

    @Override
    public void applyEffect() {
        TerritoryState terrfrom = Game.getInstance().revoltFrom;
        TerritoryState terrto = Game.getInstance().revoltTo;
        int from = terrfrom.getArmies();
        int to = terrto.getArmies();
        terrfrom.setArmies(1);
        terrto.setArmies(from+to);
        Game.getInstance().revoltFrom = null;
        Game.getInstance().revoltTo = null;
    }

}
