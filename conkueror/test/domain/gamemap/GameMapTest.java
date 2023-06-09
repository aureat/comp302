package domain.gamemap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameMapTest {

    static final String MAP_NAME = "TestMap";
    static final String MAP_DESCRIPTION = "A test map.";

    static class Continent implements ContinentType {

        private final String name;
        private final List<TerritoryType> territories;

        Continent(String name) {
            this.name = name;
            this.territories = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addTerritory(TerritoryType territory) {
            territories.add(territory);
        }

        public boolean hasTerritory(TerritoryType territory) {
            return territories.contains(territory);
        }

        public List<TerritoryType> getTerritories() {
            return territories;
        }

    }

    static class Territory implements TerritoryType {

        private final String name;
        private final ContinentType continent;
        private final List<TerritoryType> neighbors;

        Territory(String name, ContinentType continent) {
            this.name = name;
            this.continent = continent;
            this.neighbors = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public ContinentType getContinent() {
            return continent;
        }

        public void addNeighbor(TerritoryType neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasNeighbor(TerritoryType neighbor) {
            return neighbors.contains(neighbor);
        }

        public List<TerritoryType> getNeighbors() {
            return neighbors;
        }

    }

    @UseMap(name = MAP_NAME)
    @MapDescription(MAP_DESCRIPTION)
    static class TestMap extends GameMap {

        public TestMap() {

        }

        @Override
        public void createMap() {

            // Set info about map
            setName();
            setDescription();

            // Define continents
            Continent C1 = new Continent("C1");
            Continent C2 = new Continent("C2");

            // Define territories
            Territory T1 = new Territory("T1", C1);
            Territory T2 = new Territory("T2", C1);
            Territory T3 = new Territory("T3", C2);
            Territory T4 = new Territory("T4", C2);

            // Define members
            C1.addTerritory(T1);
            C1.addTerritory(T2);
            C2.addTerritory(T3);
            C2.addTerritory(T4);

            /*
             * T1 neighbors: T2
             * T2 neighbors: T1, T3
             * T3 neighbors: T2, T4
             * T4 neighbors: T3
             */
            T1.addNeighbor(T2);
            T2.addNeighbor(T3);
            T3.addNeighbor(T4);

            // Create map
            createContinents(new ContinentType[] {C1, C2});
            createTerritories(new TerritoryType[] {T1, T2, T3, T4});

        }

    }

    private final TestMap map = new TestMap();
    private final List<ContinentType> continents = new ArrayList<>();
    private final List<TerritoryType> territories = new ArrayList<>();

    public GameMapTest() {

        // Initialize map
        map.createMap();

        // Save map members
        continents.addAll(map.getContinents());
        territories.addAll(map.getTerritories());

    }



    @Test
        /*
         * REQUIRES: the 'map' variable is instantiated and the map is created by invoking 'map.createMap()'
         * MODIFIES: none
         * EFFECTS:  Verifies that the map, continents and territories are not null, checks map's name and description,
         *           checks that continents and territories lists are not empty, and that they contain no null values.
         *           Also, it checks that each territory has neighbors and each continent has territories.
         */
    void testMapValidity() {

        // Check if map is created
        assertNotNull(map);

        // Check if map info is set
        assertEquals(MAP_NAME, map.getName());
        assertEquals(MAP_DESCRIPTION, map.getDescription());

        // Check if map members are created
        assertNotNull(continents);
        assertNotNull(territories);

        // Check if map members are not empty
        assertFalse(continents.isEmpty());
        assertFalse(territories.isEmpty());

        // Check if map members are not null
        territories.forEach(Assertions::assertNotNull);
        continents.forEach(Assertions::assertNotNull);

        // Check if map members are not empty
        territories.forEach(territory -> assertFalse(territory.getNeighbors().isEmpty()));
        continents.forEach(continent -> assertFalse(continent.getTerritories().isEmpty()));

    }

    @Test
        /*
         * REQUIRES: 'continents' list is populated after the creation of the map
         * MODIFIES: none
         * EFFECTS:  Verifies the number of continents and checks the names of the first two continents.
         */
    void testContinents() {
        assertEquals(continents.size(), 2);
        assertEquals(continents.get(0).getName(), "C1");
        assertEquals(continents.get(1).getName(), "C2");
    }

    @Test
        /*
         * REQUIRES: 'territories' list is populated after the creation of the map
         * MODIFIES: none
         * EFFECTS:  Verifies the number of territories and checks the names of all four territories.
         */
    void testTerritories() {
        assertEquals(territories.size(), 4);
        assertEquals(territories.get(0).getName(), "T1");
        assertEquals(territories.get(1).getName(), "T2");
        assertEquals(territories.get(2).getName(), "T3");
        assertEquals(territories.get(3).getName(), "T4");
    }

    @Test
        /*
         * REQUIRES: 'continents' and 'territories' lists are populated after the creation of the map
         * MODIFIES: none
         * EFFECTS:  Verifies that the first two territories belong to the first continent
         *           and the last two territories belong to the second continent.
         */
    void testContinentTerritories() {
        assertTrue(continents.get(0).hasTerritory(territories.get(0)));
        assertTrue(continents.get(0).hasTerritory(territories.get(1)));
        assertTrue(continents.get(1).hasTerritory(territories.get(2)));
        assertTrue(continents.get(1).hasTerritory(territories.get(3)));
    }

    @Test
        /*
         * REQUIRES: 'territories' list is populated after the creation of the map
         * MODIFIES: none
         * EFFECTS:  Verifies the neighboring relationship between different territories
         */
    void testTerritoryNeighbors() {
        assertTrue(territories.get(0).hasNeighbor(territories.get(1)));
        assertTrue(territories.get(1).hasNeighbor(territories.get(0)));
        assertTrue(territories.get(1).hasNeighbor(territories.get(2)));
        assertTrue(territories.get(2).hasNeighbor(territories.get(1)));
        assertTrue(territories.get(2).hasNeighbor(territories.get(3)));
        assertTrue(territories.get(3).hasNeighbor(territories.get(2)));
    }

}