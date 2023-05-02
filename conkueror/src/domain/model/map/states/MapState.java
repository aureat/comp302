package domain.model.map.states;

import domain.model.map.GameMap;
import domain.model.map.types.ContinentType;
import domain.model.map.types.TerritoryType;
import domain.model.player.Player;
import domain.model.map.GameMap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapState {

    private GameMap map;

    private HashMap<ContinentType, ContinentState> continents;
    private HashMap<TerritoryType, TerritoryState> territories;

    private MapState(GameMap map) {
        this.map = map;
        continents = new HashMap<>();
        territories = new HashMap<>();
    }

    public static MapState createFromMap(GameMap map) {
        return new MapState(map);
    }

//    public HashMap<TerritoryType, TerritoryState> getTerritoriesOf(Player player) {
//        HashMap<TerritoryType, TerritoryState> playerTerritories = new HashMap<TerritoryType, TerritoryState>();
//        for (TerritoryState territory: territories.values()) {
//            if (territory.getOwner().equals(player)) {
//                playerTerritories.put(territory.getTerritoryType(), territory);
//            }
//        }
//
//        return playerTerritories;
//    }

    public List<TerritoryState> getTerritoriesOf(Player player) {
        List<TerritoryState> states = new ArrayList<>(territories.values().stream().toList());
        for(TerritoryState st : states) {
            if(!st.getOwner().equals(player)) states.remove(st);
        }
        return states;
    }


    public HashMap<TerritoryType, TerritoryState> getAttackingTerritories(Player player) {
        HashMap<TerritoryType, TerritoryState> attackbase = new HashMap<TerritoryType, TerritoryState>();

        for (TerritoryState terr : territories.values()) {
            if (terr.canStartAttack()) attackbase.put(terr.getTerritoryType(), terr);
        }
        return attackbase;
    }

    public HashMap<TerritoryState, TerritoryState> getAttackableTerritoriesFrom(TerritoryState territoryState) {
        HashMap<TerritoryState, TerritoryState> attackloc = new HashMap<TerritoryState, TerritoryState>();

        for (TerritoryType terr: territories.keySet()) {
            if (territoryState.equals(territories.get(terr))) {
                for (TerritoryType t: terr.getNeighbors()) {
                    for (TerritoryState terrs: territories.values()) {
                        if (territories.get(terr).equals(terrs) && terrs.getArmies() == territories.get(t).getArmies()) {
                            attackloc.put(terrs,territories.get(t));
                        }
                    }
                }
            }
        }
        return attackloc;
    }

    public HashMap<ContinentType, ContinentState> continentsConqueredBySinglePlayer() {
        HashMap<ContinentType, ContinentState> continentsconquered = new HashMap<ContinentType, ContinentState>();

        for (ContinentType contype : continents.keySet()) {
            ArrayList<Player> contplayers = new ArrayList<Player>();
            for(TerritoryType contterr :contype.getTerritories()) {
                contplayers.add(territories.get(contterr).getOwner());
            }
            if (contplayers.size() == 1) continentsconquered.put(contype, continents.get(contype));
        }

        return continentsconquered;

    }
    public HashMap<TerritoryType, TerritoryState> getTerritories() {
        return territories;
    }

    public HashMap<ContinentType, ContinentState> getContinents() {
        return continents;
    }
}

