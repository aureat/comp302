package domain.game.config;

import domain.card.ArmyType;
import domain.gamemap.GameMap;
import domain.gamemap.UseMap;
import util.ClassUtils;
import util.ModuleInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public abstract class GameConfig {

    private static GameConfig instance;

    public static GameConfig get() {
        if (instance == null) {
            instance = scanConfig();
        }
        return instance;
    }

    /*
     *  Configuration
     */

    public abstract int getInitialPlayers();
    public abstract int getMinimumPlayers();
    public abstract int getMaximumPlayers();
    public abstract int getDiceSides();
    public abstract int getDefaultDiceBias();
    public abstract double getRollOneBiasWeight();
    public abstract double getRollTwoBiasWeight();
    public abstract int getInitialArmies(int playerCount);
    public abstract int getInfantryPerPlayer();
    public abstract int getCavalryPerPlayer();
    public abstract int getArtilleryPerPlayer();
    public abstract int getInfantryTradeValue();
    public abstract int getCavalryTradeValue();
    public abstract int getArtilleryTradeValue();
    public abstract int getArmyCardTradeResult(List<ArmyType> types);

    /*
     * Meta
     */

    private final List<GameMap> maps = new ArrayList<>();

    private String name;

    public String getName() {
        return name;
    }

    public void setName() {
        setName(getClass().getAnnotation(UseConfig.class).name());
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GameMap> getMaps() {
        return maps;
    }

    protected void registerMaps() {
        ClassUtils.getSubTypes(ModuleInfo.MapsPackage, GameMap.class, UseMap.class)
                .forEach(this::registerMap);
    }

    protected void registerMap(Class<? extends GameMap> map) {
        try {
            maps.add(map.getDeclaredConstructor().newInstance());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private void initConfig() {
        setName();
        registerMaps();
    }

    public static GameConfig scanConfig() throws RuntimeException {
        Set<Class<? extends GameConfig>> configs =
                ClassUtils.getSubTypes(ModuleInfo.ConfigsPackage, GameConfig.class, UseConfig.class);
        if (configs.size() != 1) {
            throw new RuntimeException("There must be exactly one GameConfig class in the configs package.");
        }
        Class<? extends GameConfig> config = configs.iterator().next();
        try {
            instance = config.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("The GameConfig class must have a public no-args constructor.");
        }
        instance.initConfig();
        return instance;
    }

}
