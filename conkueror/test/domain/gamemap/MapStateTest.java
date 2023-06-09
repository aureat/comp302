package domain.gamemap;
import domain.gamemap.ContinentType;
import domain.gamemap.GameMap;
import domain.gamemap.TerritoryType;
import domain.mapstate.MapState;
import domain.mapstate.TerritoryState;
import domain.player.Player;


 //This is a test class for MapState class.
 //MapState holds the state of the game map including ownership and army counts.
 //each territory t in c.territories represents the ownership and number of armies of the corresponding territory in the game map.

public class MapStateTest {
    private GameMap gameMap;
    private MapState mapState;


     //Requires: None
     //Effects: Initialize gameMap, mapState. Add territories and their neighbors in gameMap.

    public void TestSetup() {
        createGameMap();
        shufflePlayers();
        shareTerritories();
    }

     //Test method for getNeighborsOf.
     //Requires: territoryState is not null
     //Effects: Test getNeighborsOf method, Assert neighbors

    public void testGetNeighborsOf() {
        // Create a TerritoryType
        TerritoryType territory = // Initialize territory should be in this part

                // Create a TerritoryState your choice
                TerritoryState territoryState = new TerritoryState(territory);

        // Set an owner
        Player player = new Player();
        territoryState.setOwner(player);

        // Test
        List<TerritoryState> neighbors = mapState.getNeighborsOf(territoryState);

        // Assert the neighbors.
        // For example, if in this case we put 2.
        Assert.assertEquals(2, neighbors.size());
    }

}