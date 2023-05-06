package domain.mapstate;

import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.gamemap.TerritoryType;
import domain.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapState {

    private static class MapStateContainer {
        private static MapState instance;
    }

    public static MapState getInstance() {
        return MapStateContainer.instance;
    }

    public static MapState createInstance(GameMap map) {
        if (MapStateContainer.instance == null) {
            MapStateContainer.instance = new MapState(map);
        }
        return getInstance();
    }

    private GameMap map;

    private HashMap<ContinentType, ContinentState> continents = new HashMap<>();
    private HashMap<TerritoryType, TerritoryState> territories = new HashMap<>();

    private MapState(GameMap map) {
        for (ContinentType continentType : map.getContinents()) {
            continents.put(continentType, new ContinentState(continentType));
        }
        for (TerritoryType territoryType : map.getTerritories()) {
            territories.put(territoryType, new TerritoryState(territoryType));
        }
    }

    public List<ContinentState> getContinentStates() {
        return new ArrayList<>(continents.values());
    }

    public List<TerritoryState> getTerritoryStates(Player player) {
        List<TerritoryState> states = getTerritoryStates();
        states.removeIf(state -> state.getOwner() != player);
        return states;
    }

    public List<TerritoryState> getTerritoryStates(ContinentState continentState) {
        List<TerritoryState> states = getTerritoryStates();
        states.removeIf(state -> state.getContinent() != continentState.getContinentType());
        return states;
    }

    public List<TerritoryState> getTerritoryStates(ContinentType continentType) {
        List<TerritoryState> states = getTerritoryStates();
        states.removeIf(state -> state.getContinent() != continentType);
        return states;
    }

    public List<TerritoryState> getTerritoryStates() {
        return new ArrayList<>(territories.values());
    }

    public TerritoryState getTerritoryState(TerritoryType territoryType) {
        return territories.get(territoryType);
    }

    public TerritoryState getTerritoryState(String name) {
        for (TerritoryState territoryState : territories.values()) {
            if (territoryState.getName().equals(name)) {
                return territoryState;
            }
        }
        return null;
    }

    public ContinentState getContinentState(ContinentType continentType) {
        return continents.get(continentType);
    }

    public HashMap<ContinentType, ContinentState> getContinents() {
        return continents;
    }

    public HashMap<TerritoryType, TerritoryState> getTerritories() {
        return territories;
    }

}
