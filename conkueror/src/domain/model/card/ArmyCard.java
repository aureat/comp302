package domain.model.card;

import domain.model.army.ArmyType;
import domain.model.*;

public class ArmyCard extends Card {

    private ArmyType type;

    public ArmyCard(ArmyType type) {
        this.type = type;
    }

}
