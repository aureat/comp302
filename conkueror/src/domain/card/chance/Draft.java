package domain.card.chance;

import domain.game.Game;

public class Draft implements ChanceEffect {

    @Override
    public void applyEffect() {
        Game.getInstance().getCurrentPlayer().addEffect(EffectType.Draft);
    }

}
