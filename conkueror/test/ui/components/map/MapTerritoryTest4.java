package ui.components.map;

import domain.game.Dice;
import domain.game.Game;
import domain.game.Phase;
import domain.mapstate.MapState;
import domain.player.Player;
import domain.util.CoreUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import domain.mapstate.TerritoryState;
import ui.app.controllers.MapController;
import ui.app.router.Route;
import ui.assets.Fonts;
import java.util.Random;


import javax.swing.*;
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

class MapTerritoryTest4 {

    @Test
    void testMousePressedInFortifyPhaseAndNonDonor() {
        Fonts.register();
        Game game = Game.getInstance();
        game.createGameMap();
        game.shareTerritories();
        MapState mapState = game.getMapState();
        WorldMap map = new WorldMap(false);
        map.setMapState();
        TerritoryState state = CoreUtils.chooseRandom(mapState.getTerritoryStates());
        MapTerritory mapTerritory = map.getTerritories().stream().filter(t -> t.getState() == state).findFirst().orElse(null);
        int armies = state.getArmies();
        int draftArmies = game.getDraftArmies();
        boolean isSelected = mapTerritory.isSelected();
        MouseEvent mouseEvent = new MouseEvent(mapTerritory, MouseEvent.MOUSE_PRESSED,0,0,0,0,1,true);

        assertTrue(repOk(mapTerritory));
        mapTerritory.mousePressed(mouseEvent);
        game.setPhase(Phase.Fortify);
        mapTerritory.mousePressed(mouseEvent);
        if (state.getOwner() == game.getCurrentplayer() && !(state.isDonor())) {
            assertTrue(mapTerritory.isSelected());
            assertTrue(state.isDonor());
            for (TerritoryState t : state.getOwner().getTerritories()){
                if (t != state && t.isDonor()){
                    assertFalse(mapTerritory.isSelected());
                    assertFalse(state.isDonor());
                    assertFalse(t.isDonor());
                }
            }
        }
        assertTrue(repOk(mapTerritory));
    }

    boolean repOk(MapTerritory mapTerritory) {
        return mapTerritory.getState().getArmies() > 0 && mapTerritory.getState().getOwner() != null;
    }

}
