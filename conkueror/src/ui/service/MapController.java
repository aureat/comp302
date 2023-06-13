package ui.service;

import domain.card.ChanceCard;
import domain.card.chance.EffectType;
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
        Game,
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
        if (selectedMapTerritory != null) {
            selectedMapTerritory.setSelected(false);
        }
        selectedMapTerritory = mapTerritory;
        selectedMapTerritory.setSelected(true);
    }

    public void deselect() {
        if (selectedMapTerritory != null) {
            selectedMapTerritory.setSelected(false);
            selectedMapTerritory = null;
        }
    }

    public void selectAll() {
        getMapTerritories().forEach(mapTerritory -> mapTerritory.setSelected(true));
    }

    public void deselectAll() {
        getMapTerritories().forEach(mapTerritory -> mapTerritory.setSelected(false));
    }

    public void handleMapTerritoryClick(MapTerritory mapTerritory) {

        if (mode == Mode.Build) {
            mapTerritory.getState().togglePlayable();
            System.out.println(mapTerritory.getState().isPlayable());
            mapTerritory.toggleSelected();
            return;
        }

        if (!mapTerritory.getState().isPlayable()) {
            return;
        }

        if (mode == Mode.Game) {
            GameController.getInstance().updatePhasePanel();
        }

        ChanceCard card = game.getCurrentChanceCard();
        boolean chanceCardMode = GameController.getInstance().isChanceCardMode();
        boolean armyCardMode = GameController.getInstance().isArmyCardMode();

        if (armyCardMode) {
            if (mapTerritory.getState().getOwner() != game.getCurrentPlayer()) {
                return;
            }
            game.armiesTo = mapTerritory.getState();
            game.applyArmyCard();
            updateMapTerritories();
            GameController.getInstance().endArmyCard();
            return;
        }

        if (chanceCardMode && card.getEffect() == EffectType.NuclearStrike) {
            if (mapTerritory.getState().getOwner() == game.getCurrentPlayer()) {
                return;
            }
            game.nukeTo = mapTerritory.getState();
            game.applyChanceCard();
            updateMapTerritories();
            GameController.getInstance().endEffectCard();
            return;
        }

        if (chanceCardMode && card.getEffect() == EffectType.Reinforcements) {
            if (mapTerritory.getState().getOwner() != game.getCurrentPlayer()) {
                return;
            }
            game.reinforcementsTo = mapTerritory.getState();
            game.applyChanceCard();
            updateMapTerritories();
            GameController.getInstance().endEffectCard();
            return;
        }

        if (chanceCardMode && card.getEffect() == EffectType.Revolt) {
            if (game.revoltFrom == null && mapTerritory.getState().getOwner() == game.getCurrentPlayer()) {
                game.revoltFrom = mapTerritory.getState();
                setSelectedMapTerritory(mapTerritory);
                return;
            }
            if (game.revoltFrom != mapTerritory.getState() && mapTerritory.getState().getOwner() == game.getCurrentPlayer()) {
                game.revoltTo = mapTerritory.getState();
                game.applyChanceCard();
                deselect();
                updateMapTerritories();
                GameController.getInstance().endEffectCard();
            }
            return;
        }

        if (game.getPhase() == Phase.Draft && mapTerritory.getState().getOwner() == game.getCurrentPlayer()) {
            Game.getInstance().performDraft(mapTerritory.getState());
            mapTerritory.update();
            GameController.getInstance().updatePhasePanel();
            return;
        }

        if (game.getPhase() == Phase.Attack && selectedMapTerritory == mapTerritory) {
            List<TerritoryState> neighbors = game.getAttackableNeighborsOf(selectedMapTerritory.getState());
            neighbors.forEach(neighbor -> getMapTerritory(neighbor).setSelected(false));
            deselect();
            return;
        }

        if (game.getPhase() == Phase.Attack && selectedMapTerritory == null) {
            if (
                    mapTerritory.getState().getOwner() == game.getCurrentPlayer() &&
                    mapTerritory.getState().canStartAttack()
            ) {
                    setSelectedMapTerritory(mapTerritory);
                    List<TerritoryState> neighbors = game.getAttackableNeighborsOf(mapTerritory.getState());
                    neighbors.forEach(neighbor -> getMapTerritory(neighbor).setSelected(true));
            }
            return;
        }

        if (game.getPhase() == Phase.Attack && selectedMapTerritory != null) {
            List<TerritoryState> neighbors = game.getAttackableNeighborsOf(selectedMapTerritory.getState());
            if (neighbors.contains(mapTerritory.getState())) {
                game.performAttack(selectedMapTerritory.getState(), mapTerritory.getState());
            }
            selectedMapTerritory.update();
            mapTerritory.update();
            neighbors.forEach(neighbor -> getMapTerritory(neighbor).setSelected(false));
            deselect();
            return;
        }

        if (game.getPhase() == Phase.Fortify && mapTerritory.getState().getOwner() == game.getCurrentPlayer()) {
            if (selectedMapTerritory != null) {
                game.performFortify(selectedMapTerritory.getState(), mapTerritory.getState());
                selectedMapTerritory.update();
                mapTerritory.update();
                deselect();
                deselectAll();
                return;
            }
            setSelectedMapTerritory(mapTerritory);
            game.getCurrentPlayer().getTerritories().forEach(territory -> {
                if (territory != mapTerritory.getState()) {
                    getMapTerritory(territory).setSelected(true);
                }
            });
            return;
        }
    }

}
