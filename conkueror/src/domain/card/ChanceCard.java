package domain.card;

import domain.card.chance.EffectType;
import util.CoreUtils;

import java.util.Random;

public class ChanceCard extends Card {

    private final EffectType effect;

    private boolean isUsed = false;

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

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public boolean isUsed() {
        return isUsed;
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
        double rand = new Random().nextDouble();

        if (rand < 0.12) {
            return EffectType.NuclearStrike;
        }

        if (rand < 0.36) {
            return EffectType.Reinforcements;
        }

        if (rand < 0.66) {
            return EffectType.Revolt;
        }

        if (rand < 0.88) {
            return EffectType.Bombardment;
        }

        return EffectType.Draft;

    }

    public static String typeToString(EffectType type) {
        return type.toString().replaceAll("(.)([A-Z])", "$1 $2");
    }

}
