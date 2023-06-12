package domain.card.chance;

import domain.game.Game;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import util.CoreUtils;

public class NuclearStrike implements ChanceEffect {

    @Override
    public void applyEffect() {
        Player player = Game.getInstance().getCurrentPlayer();
        TerritoryState pterr = CoreUtils.chooseRandom(player.getTerritories());
        Game.getInstance().nukeTo.setPlayable(false);
        pterr.setPlayable(false);
        Game.getInstance().nukeTo = null;
    }

}
