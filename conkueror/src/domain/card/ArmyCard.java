package domain.card;

public class ArmyCard extends Card {

    private final ArmyType armyType;

    public ArmyCard(ArmyType armyType) {
        super(CardType.Army);
        this.armyType = armyType;
    }

    public ArmyType getArmyType() {
        return armyType;
    }

}
