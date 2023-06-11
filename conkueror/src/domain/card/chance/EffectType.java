package domain.card.chance;

public enum EffectType {

    Revolt (new Revolt()),
    NuclearStrike (new NuclearStrike()),
    Draft (new Draft()),
    Bombardment (new Bombardment()),
    Reinforcements (new Reinforcements());

    private final ChanceEffect effectStrategy;

    EffectType(ChanceEffect effect) {
        this.effectStrategy = effect;
    }

    public ChanceEffect getEffectStrategy() {
        return this.effectStrategy;
    }

    public void applyEffectStrategy() {
        this.effectStrategy.applyEffect();
    }

}