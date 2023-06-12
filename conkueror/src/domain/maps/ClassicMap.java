package domain.maps;

import domain.gamemap.*;
import util.CoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The classic map of ConKUeror.
 * This map is based on the classic Risk map.
 * It has 6 continents and 39 territories.
 *
 * @see domain.gamemap.UseMap
 * @see domain.gamemap.GameMap
 * @see domain.gamemap.ContinentType
 * @see domain.gamemap.TerritoryType
 */
@UseMap(name="Classic")
@MapDescription("Play the classic world map of ConKUeror.")
public class ClassicMap extends GameMap {

    private enum Continent implements ContinentType {
        NorthAmerica,
        SouthAmerica,
        Europe,
        Asia,
        Africa,
        Oceania;

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
        Alaska (Continent.NorthAmerica),
        Greenland (Continent.NorthAmerica),
        Northwest (Continent.NorthAmerica, Alaska, Greenland),
        Alberta (Continent.NorthAmerica, Alaska, Northwest),
        Ontario (Continent.NorthAmerica, Greenland, Northwest, Alberta),
        Quebec (Continent.NorthAmerica, Greenland, Ontario),
        WesternAmerica (Continent.NorthAmerica, Alberta, Ontario),
        EasternAmerica (Continent.NorthAmerica, Ontario, Quebec, WesternAmerica),
        CentralAmerica (Continent.NorthAmerica, EasternAmerica, WesternAmerica),
        Venezuela (Continent.SouthAmerica, CentralAmerica),
        Peru (Continent.SouthAmerica, Venezuela),
        Brazil (Continent.SouthAmerica, Peru, Venezuela),
        Argentina (Continent.SouthAmerica, Peru, Brazil),
        Indonesia (Continent.Oceania),
        NewGuinea (Continent.Oceania, Indonesia),
        WesternAustralia (Continent.Oceania, Indonesia),
        EasternAustralia (Continent.Oceania, NewGuinea, WesternAustralia),
        NorthAfrica (Continent.Africa, Brazil),
        Egypt (Continent.Africa, NorthAfrica),
        EastAfrica (Continent.Africa, NorthAfrica, Egypt),
        Congo (Continent.Africa, NorthAfrica, EastAfrica),
        SouthAfrica (Continent.Africa, EastAfrica, Congo),
        Madagascar (Continent.Africa, EastAfrica, SouthAfrica),
        Russia (Continent.Asia, Alaska),
        Mongolia (Continent.Asia, Russia),
        Japan (Continent.Asia, Russia),
        China (Continent.Asia, Russia, Mongolia, Japan),
        India (Continent.Asia, Mongolia, China),
        MiddleEast (Continent.Asia, Egypt, Mongolia, India),
        Siam (Continent.Asia, Indonesia, China, India),
        GreatBritain (Continent.Europe),
        Iceland (Continent.Europe, Greenland, GreatBritain),
        Scandinavia (Continent.Europe, Iceland),
        NorthernEurope (Continent.Europe, GreatBritain, Iceland, Scandinavia),
        WesternEurope (Continent.Europe, NorthAfrica, GreatBritain, NorthernEurope),
        EasternEurope (Continent.Europe, Russia, Mongolia, Scandinavia, NorthernEurope),
        SouthernEurope (Continent.Europe, NorthAfrica, NorthernEurope, WesternEurope, EasternEurope),
        Anatolia (Continent.Europe, MiddleEast, NorthernEurope, SouthernEurope, EasternEurope, Egypt),
        Persia (Continent.Europe, Mongolia, MiddleEast, EasternEurope, Anatolia);

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
