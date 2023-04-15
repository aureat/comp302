package domain.model.map;

import java.util.ArrayList;
import java.util.List;

public class Continent {

    private String name;
    private List<Territory> territories;

    public Continent(String name) {
        this.name = name;
        this.territories = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Territory> getTerritories() {
        return territories;
    }

    public void addTerritory(Territory territory) {
        territories.add(territory);
    }

    public boolean hasTerritory(Territory territory) {
        return territories.contains(territory);
    }

}
