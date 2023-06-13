package domain.card;

import java.io.Serializable;

public class ArmyCard extends Card implements Serializable {

    private final ArmyType armyType;

    public ArmyCard(ArmyType armyType) {
        super(CardType.Army);
        this.armyType = armyType;
    }

    public ArmyType getArmyType() {
        return armyType;
    }

}
