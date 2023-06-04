package domain.game;


import domain.mapstate.TerritoryState;
import domain.player.Player;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    Game game;

    @BeforeEach
    void setUp() {
        game = Game.getInstance();
        game.createGameMap();
        game.shareTerritories();
    }
    //needs create game map and share territories call from game
    //ensures that each territory has an owner
    @Test
    void shareTerritoriesTest1(){

        game.getMapState().getTerritoryStates().forEach(terr ->{
            assertTrue(terr.getOwner()!=null,"True");
        });
    }
    //needs create game map and share territories call from game
    //ensures that first round after sharing territories is draft phase
    @Test
    void shareTerritoriesTest2(){

        assertTrue(game.getPhase()==Phase.Draft,"true");
    }
    //needs create game map and share territories call from game
    //ensures that total number of armies in the game is 78
    @Test
    void shareTerritoriesTest3(){

        int totalArmies=0;
        for (TerritoryState terr : game.getMapState().getTerritoryStates()) {
            totalArmies += terr.getArmies();
        }
        assertEquals(totalArmies,78);
    }
    //needs create game map and share territories call from game
    //ensures that by default game starts with 3 players
    @Test
    void shareTerritoriesTest4(){
        assertTrue(game.getPlayersCount() == 3, "true");
    }
    //needs create game map and share territories call from game
    //ensures that each territory has 2 armies
    @Test
    void shareTerritoriesTest5(){

        game.getMapState().getTerritoryStates().forEach(terr -> {
            assertTrue(terr.getArmies()==2,"true");
        });
    }

    @AfterEach
    void cleanUp() {
        Game.destroyInstance();
        game = null;
    }
}
