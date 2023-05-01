package domain.model.map.states;

import domain.model.map.GameMap;
import domain.model.map.types.ContinentType;
import domain.model.map.types.TerritoryType;

import java.util.HashMap;

public class MapState {

    private HashMap<ContinentType, ContinentState> continents;
    private HashMap<TerritoryType, TerritoryState> territories;

    private MapState() {
        continents = new HashMap<>();
        territories = new HashMap<>();
    }

    public static MapState createFromMap(GameMap map) {
        MapState mapState = new MapState();
        return null;
    }



}
