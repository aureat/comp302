package domain.card.chance;

import domain.game.Game;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import util.CoreUtils;

public class NuclearStrike implements ChanceEffect {

    @Override
    public void applyEffect() {
        // TODO: Implement
        // terr to be selected and destroyed
        TerritoryState terr = Game.getInstance().getMapState().getTerritoryState("Alaska");
        //current player
        Player player = Game.getInstance().getCurrentPlayer();
        TerritoryState pterr = CoreUtils.chooseRandom(Game.getInstance().getCurrentPlayer().getTerritories());
        terr.setPlayable(false);
        pterr.setPlayable(false);
    }

}
