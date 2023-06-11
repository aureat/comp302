package domain.maps;

import domain.gamemap.*;
import domain.util.CoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * University map of ConKUeror.
 * This map is based on the campus of Koç University.
 * It has 4 continents and 19 territories.
 *
 * @see UseMap
 * @see GameMap
 * @see ContinentType
 * @see TerritoryType
 */
@UseMap(name="University")
@MapDescription("Play the campus map based on Koç University.")
public class UniversityMap extends GameMap {

    private enum Continent implements ContinentType {
        Dorms,
        Sports,
        Main,
        Faculties;

        private final String name;
        private final List<TerritoryType> territories;

        Continent() {
            this.name = CoreUtils.separateOnCapital(this);
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

    private enum Territory implements TerritoryType {
        DormS (Continent.Dorms),
        DormA (Continent.Dorms, DormS),
        DormB (Continent.Dorms, DormS, DormA),
        DormC (Continent.Dorms, DormA, DormB),
        DormD (Continent.Dorms, DormA, DormB, DormC),
        DormE (Continent.Dorms, DormC, DormD),
        DormF (Continent.Dorms, DormC, DormD, DormE),
        HenryFord (Continent.Dorms, DormF),
        Rectorate (Continent.Main, HenryFord),
        Omer (Continent.Main, Rectorate),
        Library (Continent.Main, Rectorate, Omer),
        SportsHall (Continent.Sports, Library, Rectorate),
        SportsField (Continent.Sports, SportsHall),
        CASE (Continent.Faculties, Library, Omer),
        SOS (Continent.Faculties, CASE),
        Medicine (Continent.Faculties, SOS, CASE),
        Sciences (Continent.Faculties, Medicine),
        Engineering (Continent.Faculties, Sciences, Medicine),
        SNA (Continent.Faculties, Engineering, SportsField);

        private final String name;
        private final Continent continent;
        private final List<TerritoryType> neighbors;

        Territory(Continent continent, Territory...neighbors) {
            this.name = CoreUtils.separateOnCapital(this);
            this.continent = continent;
            this.neighbors = new ArrayList<>(Arrays.asList(neighbors));
        }

        public String getName() {
            return name;
        }

        public Continent getContinent() {
            return continent;
        }

        public List<TerritoryType> getNeighbors() {
            return neighbors;
        }

        public void addNeighbor(TerritoryType neighbor) {
            neighbors.add(neighbor);
        }

        public boolean hasNeighbor(TerritoryType neighbor) {
            return neighbors.contains(neighbor);
        }
    }

    public void createMap() {
        createContinents(Continent.values());
        createTerritories(Territory.values());
    }

}
