package domain.mapstate;

import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.gamemap.TerritoryType;
import domain.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MapState {

    private GameMap map;

    private HashMap<TerritoryType, TerritoryState> territories = new HashMap<>();

    public MapState(GameMap map) {
        for (TerritoryType territoryType : map.getTerritories()) {
            territories.put(territoryType, new TerritoryState(territoryType));
        }
    }

    public GameMap getMap() {
        return map;
    }

    public HashMap<TerritoryType, TerritoryState> getTerritories() {
        return territories;
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

    public List<TerritoryState> getTerritoryStates() {
        return new ArrayList<>(territories.values());
    }

    public List<TerritoryState> getTerritoryStates(Player player) {
        List<TerritoryState> states = getTerritoryStates();
        states.removeIf(state -> state.getOwner() != player);
        return states;
    }

    public List<TerritoryState> getTerritoryStates(ContinentType continentType) {
        List<TerritoryState> states = getTerritoryStates();
        states.removeIf(state -> state.getContinent() != continentType);
        return states;
    }

    public List<TerritoryState> getNeighborsOf(TerritoryState territoryState) {
        List<TerritoryState> neighbors = new ArrayList<>();
        territoryState
                .getTerritoryType()
                .getNeighbors()
                .forEach(type -> neighbors.add(territories.get(type)));
        return neighbors;
    }

}
