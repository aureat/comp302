package domain.configs;

import domain.game.config.GameConfig;
import domain.game.config.UseConfig;

/**
 * Contains all the configurations for the game.
 * @see GameConfig
 */
@UseConfig(name="Default")
public class DefaultCfg extends GameConfig {

    public DefaultCfg() {}

    public int getInitialPlayers() { return 3; }

    public int getMinimumPlayers() { return 2; }

    public int getMaximumPlayers() { return 6; }

    public int getDiceSides() { return 6; }

}
