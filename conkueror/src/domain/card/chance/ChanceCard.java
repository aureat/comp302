package domain.card.chance;

import domain.util.CoreUtils;

import java.util.Arrays;

public class ChanceCard {

    private EffectType effect;

    public ChanceCard(EffectType type) {
        this.effect = type;
    }

    public ChanceCard() {
        this.effect = ChanceCard.getRandomType();
    }

    public EffectType getEffect() {
        return effect;
    }

    public String toString() {
        return typeToString(effect);
    }

    public static EffectType getRandomType() {
        return CoreUtils.chooseRandom(EffectType.values());
    }

    public static String typeToString(EffectType type) {
        return type.toString().replaceAll("(.)([A-Z])", "$1 $2");
    }

}
