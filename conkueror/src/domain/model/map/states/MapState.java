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
import java.util.Set;
import java.util.stream.IntStream;

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

    public List<TerritoryState> getTerritoriesOf(Player player) {
        List<TerritoryState> states = new ArrayList<>(territories.values().stream().toList());
        for(TerritoryState st : states) {
            if(!st.getOwner().equals(player)) states.remove(st);
        }
        return states;
    }



    public List<TerritoryState> getAttackingTerritories(Player player) {
        List<TerritoryState> attackbase = new ArrayList<>(territories.values().stream().toList());
        for (TerritoryState terr : attackbase) {
            if (!terr.canStartAttack()) attackbase.remove(terr);
        }
        return attackbase;
    }


    public List<TerritoryState> getAttackableTerritoriesForm (TerritoryState territoryState){
        List<TerritoryState> attacklocation = new ArrayList<>(territories.values().stream().toList());
        List<TerritoryType> attacklocationneighbours = territoryState.getTerritoryType().getNeighbors();
        for (TerritoryType a : attacklocationneighbours){
           if(territories.get(a).getArmies() < territoryState.getArmies()){
               attacklocation.remove(territories.get(a));
           }
        }
        return attacklocation;
    }


//    public HashMap<ContinentType, ContinentState> continentsConqueredBySinglePlayer() {
//        HashMap<ContinentType, ContinentState> continentsconquered = new HashMap<ContinentType, ContinentState>();
//
//        for (ContinentType contype : continents.keySet()) {
//            ArrayList<Player> contplayers = new ArrayList<Player>();
//            for(TerritoryType contterr :contype.getTerritories()) {
//                contplayers.add(territories.get(contterr).getOwner());
//            }
//            if (contplayers.size() == 1) continentsconquered.put(contype, continents.get(contype));
//        }
//        return continentsconquered;
//    }

    public List<TerritoryState> getTerritoryStates() {
        return new ArrayList<>(territories.values());
    }

    public List<TerritoryState> getTerritoryStates(ContinentState continent) {
        List<TerritoryState> terrs = new ArrayList<>(territories.values());
        terrs.removeIf(terr -> terr.getTerritoryType().getContinent() != continent.getContinent());
        return terrs;
    }

    public List<ContinentState> continentsConqueredBySinglePlayer() {
        List<ContinentState> continentStates = new ArrayList<>(continents.values().stream().toList());
        List<Boolean> conqueredIndices = continents.values().stream().map(continent -> {
            List<Player> players = getTerritoryStates(continent).stream().map(TerritoryState::getOwner).toList();
            Set<Player> playersSet = Set.copyOf(players);
            return playersSet.size() == 1;
        }).toList();
        IntStream.range(0, conqueredIndices.size()).forEach(index -> {
            if (!conqueredIndices.get(index)) continentStates.remove(index);
        });
        return continentStates;
    }

    public HashMap<TerritoryType, TerritoryState> getTerritories() {
        return territories;
    }

    public HashMap<ContinentType, ContinentState> getContinents() {
        return continents;
    }
}

