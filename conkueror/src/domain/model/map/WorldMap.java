package domain.model.map;

import jdk.jfr.Category;
import jdk.jfr.Description;

import java.util.ArrayList;
import java.util.List;

@Category("GameInit")
@Description("Holds all territories and continents of the game.")
public class WorldMap {

    public static WorldMap instance;

    public static WorldMap getInstance() {
        if (instance == null)
            instance = new WorldMap();
        return instance;
    }

    private List<Continent> continents;
    private List<Territory> territories;

    public WorldMap() {

        continents = new ArrayList<>();
        territories = new ArrayList<>();

        // All Continents
        Continent northAmerica = createContinent("North America");
        Continent southAmerica = createContinent("South America");
        Continent europe = createContinent("Europe");
        Continent asia = createContinent("Asia");
        Continent africa = createContinent("Africa");
        Continent oceania = createContinent("Oceania");

        // North American Territories
        Territory alaska = createTerritory("Alaska", northAmerica);
        Territory greenland = createTerritory("Greenland", northAmerica);
        Territory northwest = createTerritory("Northwest", northAmerica);
        Territory alberta = createTerritory("Alberta", northAmerica);
        Territory ontario = createTerritory("Ontario", northAmerica);
        Territory quebec = createTerritory("Quebec", northAmerica);
        Territory westernAmerica = createTerritory("Western America", northAmerica);
        Territory easternAmerica = createTerritory("Eastern America", northAmerica);
        Territory centralAmerica = createTerritory("Central America", northAmerica);

        // South American Territories
        Territory venezuela = createTerritory("Venezuela", southAmerica);
        Territory peru = createTerritory("Peru", southAmerica);
        Territory brazil = createTerritory("Brazil", southAmerica);
        Territory argentina = createTerritory("Argentina", southAmerica);

        // Oceania Territories
        Territory indonesia = createTerritory("Indonesia", oceania);
        Territory newGuinea = createTerritory("New Guinea", oceania);
        Territory westernAustralia = createTerritory("Western Australia", oceania);
        Territory easternAustralia = createTerritory("Eastern Australia", oceania);

        // African Territories
        Territory northAfrica = createTerritory("North Africa", africa);
        Territory egypt = createTerritory("North Africa", africa);
        Territory eastAfrica = createTerritory("east Africa", africa);
        Territory congo = createTerritory("Congo", africa);
        Territory southAfrica = createTerritory("South Africa", africa);
        Territory madagascar = createTerritory("Madagascar", africa);

        // Asian Territories
        Territory russia = createTerritory("Russia", asia);
        Territory mongolia = createTerritory("Mongolia", asia);
        Territory japan = createTerritory("Japan", asia);
        Territory china = createTerritory("China", asia);
        Territory india = createTerritory("India", asia);
        Territory middleEast = createTerritory("Middle East", asia);
        Territory siam = createTerritory("Siam", asia);

        // European Territories
        Territory greatBritain = createTerritory("Great Britain", europe);
        Territory iceland = createTerritory("Iceland", europe);
        Territory scandinavia = createTerritory("Scandinavia", europe);
        Territory northernEurope = createTerritory("Northern Europe", europe);
        Territory westernEurope = createTerritory("Western Europe", europe);
        Territory easternEurope = createTerritory("Eastern Europe", europe);
        Territory southernEurope = createTerritory("Southern Europe", europe);
        Territory anatolia = createTerritory("Anatolia", europe);
        Territory persia = createTerritory("Persia", europe);

        // Neighbor Relationships for Northern America
        alaska.addNeighbors(russia, northwest, alberta);
        greenland.addNeighbors(quebec, ontario, northwest, iceland);
        northwest.addNeighbors(alaska, alberta, ontario, greenland);
        alberta.addNeighbors(alaska, northwest, ontario, westernAmerica);
        ontario.addNeighbors(greenland, northwest, alberta, easternAmerica, quebec);
        easternAmerica.addNeighbors(ontario, quebec, westernAmerica, centralAmerica);
        westernAmerica.addNeighbors(alberta, ontario, easternAmerica, centralAmerica);
        centralAmerica.addNeighbors(westernAmerica, easternAmerica, venezuela);

        // Neighbor Relationships for Southern America
        venezuela.addNeighbors(centralAmerica, brazil, peru);
        peru.addNeighbors(venezuela, brazil, argentina);
        brazil.addNeighbors(venezuela, peru, argentina, northAfrica);
        argentina.addNeighbors(peru, brazil);

        // Neighbor Relationships for Oceania
        westernAustralia.addNeighbors(indonesia, easternAustralia);
        easternAustralia.addNeighbors(westernAustralia, newGuinea);
        indonesia.addNeighbors(siam, newGuinea, westernAustralia, india);
        newGuinea.addNeighbors(siam, indonesia, easternAustralia);

        // Neighbor Relationships for Africa
        northAfrica.addNeighbors(westernEurope, southernEurope, egypt, eastAfrica, congo, brazil);
        egypt.addNeighbors(anatolia, northAfrica, eastAfrica, middleEast);
        eastAfrica.addNeighbors(egypt, northAfrica, congo, southAfrica, madagascar);
        congo.addNeighbors(northAfrica, eastAfrica, southAfrica);
        southAfrica.addNeighbors(congo, eastAfrica, madagascar);
        madagascar.addNeighbors(eastAfrica, southAfrica);

        // Neighbor Relationships for Asia
        russia.addNeighbors(alaska, japan, china, mongolia, easternEurope);
        japan.addNeighbors(russia, china);
        china.addNeighbors(russia, japan, mongolia, india, siam);
        mongolia.addNeighbors(russia, easternEurope, persia, middleEast, india, china);
        india.addNeighbors(mongolia, china, siam, middleEast, indonesia);
        middleEast.addNeighbors(mongolia, india, persia, anatolia, egypt);
        siam.addNeighbors(china, india, indonesia, newGuinea);

        // Neighbor Relationships for Europe
        iceland.addNeighbors(greenland, greatBritain, scandinavia);
        greatBritain.addNeighbors(iceland, westernEurope, northernEurope);
        scandinavia.addNeighbors(iceland, northernEurope, easternEurope);
        northernEurope.addNeighbors(scandinavia, easternEurope, anatolia, southernEurope, westernEurope, greatBritain);
        westernEurope.addNeighbors(greatBritain, northernEurope, southernEurope, northAfrica);
        southernEurope.addNeighbors(northAfrica, northernEurope, westernEurope, anatolia);
        anatolia.addNeighbors(egypt, middleEast, northernEurope, southernEurope, easternEurope, persia);
        persia.addNeighbors(easternEurope, anatolia, middleEast, mongolia);
        easternEurope.addNeighbors(russia, mongolia, scandinavia, northernEurope, anatolia, persia);

    }

    public Continent createContinent(String name) {
        Continent continent = new Continent(name);
        continents.add(continent);
        return continent;
    }

    public Territory createTerritory(String name, Continent continent) {
        Territory territory = new Territory(name, continent);
        continent.addTerritory(territory);
        territories.add(territory);
        return territory;
    }

}
