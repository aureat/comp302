package domain.game.config;

import domain.gamemap.GameMap;
import domain.gamemap.UseMap;
import util.ClassUtils;
import util.module.ModuleInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class GameConfig {

    private static Class<? extends GameConfig> config;
    private static GameConfig instance;

    /*
     *  Config
     */

    public abstract int getInitialPlayers();
    public abstract int getMinimumPlayers();
    public abstract int getMaximumPlayers();

    /*
     *
     */

    private final List<Class<? extends GameMap>> maps = new ArrayList<>();

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

    public List<Class<? extends GameMap>> getMaps() {
        return maps;
    }

    protected void registerMaps() {
        ClassUtils
                .getSubTypes(ModuleInfo.MapsPackage, GameMap.class, UseMap.class)
                .forEach(this::registerMap);
    }

    protected void registerMap(Class<? extends GameMap> map) {
        maps.add(map);
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
        config = configs.iterator().next();
        try {
            instance = config.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("The GameConfig class must have a public no-args constructor.");
        }
        instance.initConfig();
        return instance;
    }

}
