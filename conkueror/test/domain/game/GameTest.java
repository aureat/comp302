package domain.game;

import domain.gamemap.ContinentType;
import domain.gamemap.TerritoryType;
import domain.mapstate.TerritoryState;
import domain.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }
    //Test case for adding players
    @Test
    public void testAddPlayer() {
        // Add players to the game
        int initialPlayerNum = game.getPlayersCount();
        Player player1 = game.addPlayer();


        // Check the number of players in the game
        assertEquals(1 + initialPlayerNum, game.getPlayerCount());

        // Check if the added players are in the players list
        List<Player> players = game.getPlayers();
        assertTrue(players.contains(player1));
    }
    //Test case for maximum number of players.

    @Test
    public void testAddMultiplePlayers() {
        // Add three players to the game
        Player player1 = game.addPlayer();
        Player player2 = game.addPlayer();
        Player player3 = game.addPlayer();
        int initialPlayerNum = 3;

        // Check the number of players in the game
        assertEquals(3 + initialPlayerNum, game.getPlayerCount());

        // Check if the added players are in the players list
        List<Player> players = game.getPlayers();
        assertTrue(players.contains(player1));
        assertTrue(players.contains(player2));
        assertTrue(players.contains(player3));
    }

    @Test
    void testAddWhenMaxPlayers(){
        // Assuming the max limit is 6 players and we already have 6 players
        for (int i = 0; i < 6; i++) {
            game.addPlayer();
        }

        // Test when adding a player exceeds the maximum limit
        assertNull(game.addPlayer(), "No new player should be added as it exceeds the maximum limit");
        assertEquals(6, game.getPlayersCount(), "There should still be 6 players");
    }


    @Test
    public void testAddPlayerAfterRemove() {

        int initialPlayerNum = game.getPlayersCount();
        // Add two players to the game
        Player player1 = game.addPlayer();
        Player player2 = game.addPlayer();

        // Remove one player from the game
        game.getPlayers().remove(player1);

        // Add another player to the game
        Player player3 = game.addPlayer();

        // Check the number of players in the game
        assertEquals(2 + initialPlayerNum, game.getPlayerCount());

        // Check if the added player is in the players list
        List<Player> players = game.getPlayers();
        assertFalse(players.contains(player1));
        assertTrue(players.contains(player2));
        assertTrue(players.contains(player3));
    }

    @Test
    public void testShufflePlayers() {
        // Assuming the initial order of players is player1, player2, player3
        Player player1 = game.addPlayer();
        Player player2 = game.addPlayer();
        Player player3 = game.addPlayer();

        // Shuffle the players
        game.shufflePlayers();

        // Get the new order of players
        List<Player> shuffledPlayers = game.getPlayers();

        // Check if the order of players is changed
        assertNotEquals(shuffledPlayers, Arrays.asList(player1, player2, player3));
    }

    @Test
    public void testShufflePlayersPreservesAllPlayers() {
        // Assuming the initial order of players is player1, player2, player3
        Player player1 = game.addPlayer();
        Player player2 = game.addPlayer();
        Player player3 = game.addPlayer();

        // Shuffle the players
        game.shufflePlayers();

        // Get the new order of players
        List<Player> shuffledPlayers = game.getPlayers();

        // Check if all players are still present
        assertTrue(shuffledPlayers.contains(player1));
        assertTrue(shuffledPlayers.contains(player2));
        assertTrue(shuffledPlayers.contains(player3));
    }

    @Test
    public void testShufflePlayersDoesNotChangePlayerCount() {
        // Assuming the initial order of players is player1, player2, player3
        Player player1 = game.addPlayer();
        Player player2 = game.addPlayer();
        Player player3 = game.addPlayer();

        // Get the initial number of players
        int initialPlayerCount = game.getPlayerCount();

        // Shuffle the players
        game.shufflePlayers();

        // Check if the number of players remains the same
        assertEquals(initialPlayerCount, game.getPlayerCount());
    }

    @Test
    public void testShuffleEmptyPlayers() {
        // Shuffle the players
        game.shufflePlayers();

        // No assertion is needed, test passes if no exception is thrown
        // and the code execution reaches this point
    }
    @Test
    public void testShuffleSinglePlayer() {
        //Remove the initial players.
        game.getPlayers().remove(0);
        game.getPlayers().remove(0);
        game.getPlayers().remove(0);
        // Add a single player to the game
        Player player = game.addPlayer();

        // Shuffle the players
        game.shufflePlayers();

        // Get the new order of players
        List<Player> shuffledPlayers = game.getPlayers();

        // Check if the order remains the same
        assertEquals(shuffledPlayers, Collections.singletonList(player));
    }

    @Test
    public void testSuccessfulAttackWithSufficientArmies() {
        // Set up the initial state
        TerritoryType attackerType = createTerritoryType("Attacker");
        TerritoryType defenderType = createTerritoryType("Defender");
        TerritoryState attackerTerritory = createTerritoryState(attackerType);
        TerritoryState defenderTerritory = createTerritoryState(defenderType);
        attackerTerritory.setArmies(4);
        defenderTerritory.setArmies(2);

        // Perform the attack
        game.attackPhase(attackerTerritory, defenderTerritory);

        // Check the result of the attack
        assertTrue(attackerTerritory.isAttacker());
        assertTrue(defenderTerritory.isDefender());
        assertEquals(1, defenderTerritory.getArmies());
        assertEquals(4, attackerTerritory.getArmies());}





    @Test
    public void testFailedAttackWithInsufficientArmies() {
        // Set up the initial state
        TerritoryType attackerType = createTerritoryType("Attacker");
        TerritoryType defenderType = createTerritoryType("Defender");
        TerritoryState attackerTerritory = createTerritoryState(attackerType);
        TerritoryState defenderTerritory = createTerritoryState(defenderType);
        attackerTerritory.setArmies(2);
        defenderTerritory.setArmies(4);
        boolean attackable =   attackerTerritory.isAttacker();
        if(attackerTerritory.getArmies() < defenderTerritory.getArmies()){
            attackable = false;
        }
        // Perform the attack
        game.attackPhase(attackerTerritory, defenderTerritory);

        // Check the result of the attack
        assertFalse(attackable);
        assertEquals(4, defenderTerritory.getArmies());
        assertEquals(2, attackerTerritory.getArmies());
    }

    @Test
    public void testAttackWithEqualArmies() {
        // Set up the initial state
        TerritoryType attackerType = createTerritoryType("Attacker");
        TerritoryType defenderType = createTerritoryType("Defender");
        TerritoryState attackerTerritory = createTerritoryState(attackerType);
        TerritoryState defenderTerritory = createTerritoryState(defenderType);
        attackerTerritory.setArmies(2);
        defenderTerritory.setArmies(2);
        boolean attackable =   attackerTerritory.isAttacker();
        if(attackerTerritory.getArmies() == defenderTerritory.getArmies()){
            attackable = false;
        }
        // Perform the attack
        game.attackPhase(attackerTerritory, defenderTerritory);

        // Check the result of the attack
        assertFalse(attackable);
        assertEquals(2, defenderTerritory.getArmies());
        assertEquals(2, attackerTerritory.getArmies());
    }
    @Test
    public void testAttackWithMinimumArmies() {
        // Set up the initial state
        TerritoryType attackerType = createTerritoryType("Attacker");
        TerritoryType defenderType = createTerritoryType("Defender");
        TerritoryState attackerTerritory = createTerritoryState(attackerType);
        TerritoryState defenderTerritory = createTerritoryState(defenderType);
        attackerTerritory.setArmies(1);
        defenderTerritory.setArmies(1);
        boolean attackable =   attackerTerritory.isAttacker();
        if(attackerTerritory.getArmies() ==1 ){
            attackable = false;
        }
        // Perform the attack
        game.attackPhase(attackerTerritory, defenderTerritory);

        // Check the result of the attack;
        assertFalse(attackable);
        assertEquals(1, defenderTerritory.getArmies());
        assertEquals(1, attackerTerritory.getArmies());
    }

    @Test
    public void testAttackToOwnTerritory() {
        // Set up the initial state
        TerritoryType attackerType = createTerritoryType("Defender"); //Here assume that defender is the same player.
        TerritoryType defenderType = createTerritoryType("Defender");
        TerritoryState attackerTerritory = createTerritoryState(attackerType);
        TerritoryState defenderTerritory = createTerritoryState(defenderType);
        attackerTerritory.setArmies(0);
        defenderTerritory.setArmies(3);

        boolean attackable =   attackerTerritory.isAttacker();
        if(attackerTerritory.getOwner() == defenderTerritory.getOwner() ){ // Attacker has no armies. //Not possible a test case but still added.
            attackable = false;
        }

        // Perform the attack
        game.attackPhase(attackerTerritory, defenderTerritory);

        // Check the result of the attack
        assertFalse(attackable);
        assertEquals(3, defenderTerritory.getArmies());
        assertEquals(0, attackerTerritory.getArmies());
    }





    private TerritoryState createTerritoryState(TerritoryType territoryType) {
        return new TerritoryState(territoryType) {
            // You can add any additional customization or behavior specific to the test case
            Player player1 = new Player();
            Player player2 = new Player();
            @Override
            public boolean isAttacker(){
                this.setOwner(player1);
                return Objects.equals(this.getName(), "Attacker");
            }

            @Override
            public boolean isDefender(){
                this.setOwner(player2);
                return Objects.equals(this.getName(), "Defender");
            }

        };
    }


    private ContinentType createContinentType(String name) {
        return new ContinentType() {
            private String continentName = name;
            private List<TerritoryType> territories = new ArrayList<>();

            @Override
            public String getName() {
                return continentName;
            }

            @Override
            public void addTerritory(TerritoryType territory) {
                territories.add(territory);
            }

            @Override
            public boolean hasTerritory(TerritoryType territory) {
                return territories.contains(territory);
            }

            @Override
            public List<TerritoryType> getTerritories() {
                return territories;
            }
        };
    }



    private TerritoryType createTerritoryType(String name) {
        return new TerritoryType() {
            private String territoryName = name;
            private ContinentType continent = createContinentType("Europe");
            private List<TerritoryType> neighbors = new ArrayList<>();

            @Override
            public String getName() {
                return territoryName;
            }

            @Override
            public ContinentType getContinent() {
                return continent;
            }

            @Override
            public void addNeighbor(TerritoryType neighbor) {
                neighbors.add(neighbor);
            }

            @Override
            public boolean hasNeighbor(TerritoryType neighbor) {
                return neighbors.contains(neighbor);
            }

            @Override
            public List<TerritoryType> getNeighbors() {
                return neighbors;
            }
        };
    }


}
