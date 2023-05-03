package domain.mapstate;

import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.gamemap.TerritoryType;

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
