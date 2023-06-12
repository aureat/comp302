package ui.components.map;

import domain.game.Game;
import domain.game.Phase;
import domain.mapstate.MapState;
import util.CoreUtils;
import org.junit.jupiter.api.Test;
import domain.mapstate.TerritoryState;
import ui.assets.Fonts;
import ui.components.maps.ClassicMapBoard;

import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

//        Class Overview
//        This class represents the state of a game, including the territories and players involved.
//        It reacts to mouse presses on territories and updates the state of the game and territories accordingly,
//        depending on the current phase of the game (Draft, Attack, or Fortify).
//
//        Abstract Function
//        A Game class object g represents the state of a game.
//        This includes the current player, phase, and a map of territories.
//        Each territory has an owner, an army count,
//        and flags indicating whether it can start an attack,
//        whether it is selected, and whether it is a donor.
//
//        Representation Invariant
//        The representation invariant for the Game class could be something like:
//
//        game != null
//        map != null
//        mapState != null
//        state != null
//        mapTerritory != null
//        mouseEvent != null

class MapTerritoryTest2 {
    @Test
    void testMousePressedInAttackPhaseAndOwnerCanStartAttack() {
        Fonts.register();
        Game game = Game.getInstance();
        game.createGameMap();
        game.shareTerritories();
        MapState mapState = game.getMapState();
        ClassicMapBoard map = new ClassicMapBoard(false);
        map.setMapState();
        TerritoryState state = CoreUtils.chooseRandom(mapState.getTerritoryStates());
        MapTerritory mapTerritory = map.getTerritories().stream().filter(t -> t.getState() == state).findFirst().orElse(null);
        int armies = state.getArmies();
        int draftArmies = game.getDraftArmies();
        boolean isSelected = mapTerritory.isSelected();
        MouseEvent mouseEvent = new MouseEvent(mapTerritory, MouseEvent.MOUSE_PRESSED,0,0,0,0,1,true);

        assertTrue(repOk(mapTerritory));

        game.setPhase(Phase.Attack);
        mapTerritory.mousePressed(mouseEvent);
        if (state.getOwner() == game.getCurrentplayer() && state.canStartAttack()) {
            assertFalse(mapTerritory.isSelected());
            for (TerritoryState territory : mapState.getTerritories().values()) {
                if (territory.isAttacker()) {
                    assertFalse(territory.isAttacker());
                }
            }
            assertTrue(mapTerritory.isSelected());
            assertTrue(state.isAttacker());
        }
        assertTrue(repOk(mapTerritory));
    }

    boolean repOk(MapTerritory mapTerritory) {
        return mapTerritory.getState().getArmies() > 0 && mapTerritory.getState().getOwner() != null;
    }
}