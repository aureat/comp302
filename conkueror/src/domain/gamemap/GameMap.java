package domain.gamemap;

import java.util.ArrayList;
import java.util.List;

/**
 * A map of the game.
 * A map has a list of continents and a list of territories.
 * A map is created by extending this class and implementing the abstract method createMap().
 *
 * @see ContinentType
 * @see TerritoryType
 */
public abstract class GameMap {

    private List<ContinentType> continents = new ArrayList<>();
    private List<TerritoryType> territories = new ArrayList<>();

    public abstract void createMap();

    private String name;
    private String description;

    public void setName() {
        try {
            name = this.getClass().getAnnotation(UseMap.class).name();
        } catch (Exception e) {
            name = "Unnamed";
        }
    }

    public void setDescription() {
        try {
            description = this.getClass().getAnnotation(MapDescription.class).value();
        } catch (Exception e) {
            description = "No description available.";
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

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

    public List<TerritoryType> getTerritories() {
        return territories;
    }

    public List<ContinentType> getContinents() {
        return continents;
    }

}
