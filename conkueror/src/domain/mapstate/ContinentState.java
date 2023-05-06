package domain.mapstate;

import domain.gamemap.ContinentType;
import domain.gamemap.TerritoryType;

import java.util.List;

public class ContinentState {

    private final ContinentType continentType;

    public ContinentState(ContinentType continentType) {
        this.continentType = continentType;
    }

    public ContinentType getContinentType() {
        return continentType;
    }

    public List<TerritoryType> getTerritories() {
        return continentType.getTerritories();
    }

}
