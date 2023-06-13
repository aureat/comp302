package domain.card;

import domain.gamemap.TerritoryType;

import java.io.Serializable;

public class TerritoryCard extends Card implements Serializable {

    private final TerritoryType territoryType;

    public TerritoryCard(TerritoryType territoryType) {
        super(CardType.Territory);
        this.territoryType = territoryType;
    }

    public TerritoryType getTerritoryType() {
        return territoryType;
    }

}
