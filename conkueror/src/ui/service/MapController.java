package ui.service;

import domain.game.Game;
import domain.game.Phase;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import ui.app.router.Route;
import ui.components.map.MapBoard;
import ui.components.map.MapTerritory;
import ui.components.maps.ClassicMapBoard;

import java.util.HashMap;
import java.util.List;

public class MapController {

    private static MapController instance;

    public static MapController createFor(MapBoard map) {
        return (instance = new MapController(map));
    }

    public static MapController get() {
        return instance;
    }

    public enum Mode {
        Build,
        Game
    }

    private final MapBoard map;
    private final HashMap<TerritoryState, MapTerritory> mapTerritories;
    private final Game game = Game.getInstance();
    private final MapState mapState = game.getMapState();

    private Mode mode;
    private MapTerritory selectedMapTerritory;

    private MapController(MapBoard map) {
        this.map = map;
        this.mapTerritories = new HashMap<>();
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Mode getMode() {
        return mode;
    }

    public void addMapTerritory(TerritoryState state, MapTerritory territory) {
        mapTerritories.put(state, territory);
    }

    public MapTerritory getMapTerritory(TerritoryState state) {
        return mapTerritories.get(state);
    }

    public List<MapTerritory> getMapTerritories() {
        return mapTerritories.values().stream().toList();
    }

    public TerritoryState getTerritoryState(String name) {
        return mapState.getTerritoryState(name);
    }

    public void updateMapTerritories() {
        mapTerritories.values().forEach(MapTerritory::update);
    }

    public void updateMapTerritory(TerritoryState state) {
        mapTerritories.get(state).update();
    }

    public void setSelectedMapTerritory(MapTerritory mapTerritory) {
        selectedMapTerritory.setSelected(false);
        selectedMapTerritory = mapTerritory;
        selectedMapTerritory.setSelected(true);
    }

    public void deselect() {
        if (selectedMapTerritory != null) {
            selectedMapTerritory.setSelected(false);
            selectedMapTerritory = null;
        }
    }

    public void deselectAll() {
        getMapTerritories().forEach(mapTerritory -> mapTerritory.setSelected(false));
    }

    public void handleMapTerritoryClick(MapTerritory mapTerritory) {

        if (mode == Mode.Build) {
            mapTerritory.getState().togglePlayable();
            mapTerritory.toggleSelected();
            return;
        }

        mapTerritory.toggleSelected();


//        if (!isBuildMode && isPlayable) {
//            if (Game.getInstance().getPhase() == Phase.Draft) {
//                if (state.getOwner()==Game.getInstance().getCurrentplayer()) {
//                    Game.getInstance().setDraftArmies(state);
//                    Route.GameMap.getController().update();
//                    update();
//                }
//            } else if (Game.getInstance().getPhase() == Phase.Attack) {
//                if (state.getOwner() == Game.getInstance().getCurrentplayer() && state.canStartAttack()) {
//                    MapController.deselectAll();
//                    for (TerritoryState territory : MapState.getInstance().getTerritories().values()) {
//                        if (territory.isAttacker()) {
//                            territory.setAttacker(false);
//                        }
//                    }
//                    setSelected(true);
//                    state.setAttacker(true);
//                    Route.GameMap.getController().update();
//                    MapController.map.repaint();
//                } else if (state.getOwner() != Game.getInstance().getCurrentplayer()) {
//                    for (TerritoryState territory : MapState.getInstance().getTerritories().values()) {
//                        if (territory.isAttacker()) {
//                            for (TerritoryState t : MapState.getInstance().getNeighborsOf(territory) ){
//                                if(t==state) {
//                                    MapController.deselectAll();
//                                    Game.getInstance().attackPhase(territory, state);
//                                    territory.setAttacker(false);
//                                    Route.GameMap.update();
//                                    MapController.map.repaint();
//                                    MapController.map.updateOnMap(territory);
//                                    MapController.map.updateOnMap(state);
//                                }
//                            }
//                        }
//                    }
//                }
//            } else if (Game.getInstance().getPhase() == Phase.Fortify) {
//                if (state.getOwner() == Game.getInstance().getCurrentplayer()&& !(state.isDonor())) {
//                    setSelected(true);
//                    state.setDonor(true);
//                    for (TerritoryState t : state.getOwner().getTerritories()){
//                        if (t!=state && t.isDonor()){
//                            MapController.deselectAll();
//                            state.setDonor(false);
//                            Game.getInstance().fortifyPhase(t,state);
//                            MapController.deselectAll();
//                            t.setDonor(false);
//                            Route.GameMap.update();
//                            MapController.map.repaint();
//                            MapController.map.updateOnMap(t);
//                            MapController.map.updateOnMap(state);
//                        }
//                    }
//                    Route.GameMap.update();
//                    MapController.map.updateOnMap(state);
//                    Route.GameMap.getController().update();
//                    update();
//                    MapController.map.repaint();
//                }else if (state.getOwner() == Game.getInstance().getCurrentplayer()&& state.isDonor()){
//                    setSelected(false);
//                    state.setDonor(false);
//                    Route.GameMap.update();
//                    MapController.map.updateOnMap(state);
//                    Route.GameMap.getController().update();
//                    update();
//                    MapController.map.repaint();
//                }
//            }
//        }
    }

}
