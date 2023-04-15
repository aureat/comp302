package domain.model.card;

import domain.model.map.Territory;

public class TerritoryCard extends Card {

    private Territory territory;

    public TerritoryCard(Territory territory) {
        this.territory = territory;
    }

}
