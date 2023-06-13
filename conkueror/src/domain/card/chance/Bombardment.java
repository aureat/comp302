package domain.card.chance;

import domain.game.Game;

public class Bombardment implements ChanceEffect {

    @Override
    public void applyEffect() {
        Game.getInstance().getCurrentPlayer().addEffect(EffectType.Bombardment);
    }

}
