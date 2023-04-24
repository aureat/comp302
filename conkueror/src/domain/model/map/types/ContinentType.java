package domain.model.map.types;

import java.util.List;


/**
 * Classes that implement ContinentType represent continents in the map.
 * A continent has a name and a list of territories.
 *
 * @see domain.model.map.GameMap
 */
public interface ContinentType {
    String getName();
    void addTerritory(TerritoryType territory);
    boolean hasTerritory(TerritoryType territory);
    List<TerritoryType> getTerritories();
}
