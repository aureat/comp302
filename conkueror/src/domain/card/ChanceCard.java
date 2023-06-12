package domain.card;

import domain.card.chance.EffectType;
import util.CoreUtils;

public class ChanceCard extends Card {

    private final EffectType effect;

    public ChanceCard(EffectType type) {
        super(CardType.Chance);
        this.effect = type;
    }

    public ChanceCard() {
        this(getRandomType());
    }

    public EffectType getEffect() {
        return effect;
    }

    public String getName() {
        return typeToString(effect);
    }

    public void apply() {
        effect.applyEffectStrategy();
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
