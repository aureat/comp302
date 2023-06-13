package domain.card.chance;

import domain.game.Game;

import java.io.Serializable;

public class Bombardment implements ChanceEffect, Serializable {

    @Override
    public void applyEffect() {
        Game.getInstance().getCurrentPlayer().addEffect(EffectType.Bombardment);
    }

}
