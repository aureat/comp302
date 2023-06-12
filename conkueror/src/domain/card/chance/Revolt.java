package domain.card.chance;

import domain.game.Game;
import domain.mapstate.TerritoryState;

public class Revolt implements ChanceEffect {

    @Override
    public void applyEffect() {
        // TODO: Implement
        // terr to get armies
        TerritoryState terrfrom = Game.getInstance().getMapState().getTerritoryState("Alaska");
        // terr to add armies
        TerritoryState terrto = Game.getInstance().getMapState().getTerritoryState("North Western");
        int from = terrfrom.getArmies();
        int to = terrto.getArmies();
        terrfrom.setArmies(1);
        terrto.setArmies(from+to);
    }

}
