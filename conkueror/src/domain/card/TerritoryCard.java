package domain.card;

import domain.gamemap.TerritoryType;

public class TerritoryCard extends Card {

    private final TerritoryType territoryType;

    public TerritoryCard(TerritoryType territoryType) {
        super(CardType.Territory);
        this.territoryType = territoryType;
    }

    public TerritoryType getTerritoryType() {
        return territoryType;
    }

}
