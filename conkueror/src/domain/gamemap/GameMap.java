package domain.gamemap;

import java.util.ArrayList;
import java.util.Arrays;
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

    private final List<ContinentType> continents = new ArrayList<>();
    private final List<TerritoryType> territories = new ArrayList<>();

    private String name;
    private String description;

    public abstract void createMap();

    public void initMap() {
        setName();
        setDescription();
        createMap();
    }

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
        continents.addAll(Arrays.asList(continentValues));
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
