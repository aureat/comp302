package domain.model.map;

import domain.model.map.types.ContinentType;
import domain.model.map.types.TerritoryType;
import java.util.ArrayList;
import java.util.List;

/**
 * A map of the game.
 * A map has a list of continents and a list of territories.
 * A map is created by extending this class and implementing the abstract method createMap().
 *
 * @see domain.model.map.types.ContinentType
 * @see domain.model.map.types.TerritoryType
 */
public abstract class GameMap {

    private List<ContinentType> continents = new ArrayList<>();
    private List<TerritoryType> territories = new ArrayList<>();

    public abstract void createMap();

    public void createContinents(ContinentType[] continentValues) {
        for (ContinentType continent : continentValues) {
            continents.add(continent);
        }
    }

    public void createTerritories(TerritoryType[] territoryValues) {
        for (TerritoryType territory : territoryValues) {
            territory.getContinent().addTerritory(territory);
            territories.add(territory);
            for (TerritoryType neighbor : territory.getNeighbors()) {
                if (!neighbor.hasNeighbor(territory)) {
                    neighbor.addNeighbor(territory);
                }
            }
        }
    }

    public abstract String getName();
    public abstract String getDescription();

    public List<TerritoryType> getTerritories() {
        return territories;
    }

    public List<ContinentType> getContinents() {
        return continents;
    }

}
