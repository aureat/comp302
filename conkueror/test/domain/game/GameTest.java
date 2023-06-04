package domain.game;


import domain.mapstate.TerritoryState;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {

    Game game = Game.getInstance();

    @Test
    void initialArmyTest(){
        int playersCount = game.getPlayersCount();
        int result;
        switch (playersCount){
            case 2 -> result=40;
            case 3 -> result=35;
            case 4 -> result=30;
            case 5 -> result=25;
            case 6 -> result=20;
            default -> result=40;
        }
        assertEquals(result,game.getInitialArmies());
    }

    //needs create game map and share territories call from game
    //ensures that each territory has an owner
    @Test
    void shareTerritoriesTest1(){
        game.createGameMap();
        game.shareTerritories();
        game.getMapState().getTerritoryStates().forEach(terr ->{
            assertTrue(terr.getOwner()!=null,"True");
        });
    }
    //needs create game map and share territories call from game
    //ensures that first round after sharing territories is draft phase
    @Test
    void shareTerritoriesTest2(){
        game.createGameMap();
        game.shareTerritories();
        assertTrue(game.getPhase()==Phase.Draft,"true");
    }
    //needs create game map and share territories call from game
    //ensures that total number of armies in the game is 78
    @Test
    void shareTerritoriesTest3(){
        game.createGameMap();
        game.shareTerritories();
        int totalArmies=0;
        for (TerritoryState terr : game.getMapState().getTerritoryStates()) {
            totalArmies += terr.getArmies();
        }
        assertEquals(totalArmies,78);
    }
    //needs create game map and share territories call from game
    //ensures that each player gets exactly 13 territories
    @Test
    void shareTerritoriesTest4(){
        game.createGameMap();
        game.shareTerritories();
        game.getPlayers().forEach(player -> {
            assertTrue(player.getNumberOfTerritories()==13,"true");
        });
    }
    //needs create game map and share territories call from game
    //ensures that each territory has 2 armies
    @Test
    void shareTerritoriesTest5(){
        game.createGameMap();
        game.shareTerritories();
        game.getMapState().getTerritoryStates().forEach(terr -> {
            assertTrue(terr.getArmies()==2,"true");
        });
    }
}
