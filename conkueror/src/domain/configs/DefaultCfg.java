package domain.configs;

import domain.card.ArmyCard;
import domain.card.ArmyType;
import domain.game.config.GameConfig;
import domain.game.config.UseConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;

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

    public int getDefaultDiceBias() { return 1; }

    public double getRollOneBiasWeight() { return 1.0; }

    public double getRollTwoBiasWeight() { return 0.0; }

    public int getInitialArmies(int playerCount) {
        return 50 - (playerCount * 5);
    }

    public int getInfantryPerPlayer() { return 3; }

    public int getCavalryPerPlayer() { return 2; }

    public int getArtilleryPerPlayer() { return 1; }

    public int getInfantryTradeValue() { return 1; }

    public int getCavalryTradeValue() { return 5; }

    public int getArtilleryTradeValue() { return 10; }

    public int getArmyCardTradeResult(List<ArmyType> types) {

        // If types contains 3 ArmyType.Infantry, return 5
        if (types.stream().filter(type -> type == ArmyType.Infantry).count() >= 3) {
            return getCavalryTradeValue();
        }

        // If types contains 2 Infantry and 1 Cavalry, return 10
        if (types.stream().filter(type -> type == ArmyType.Infantry).count() >= 2 &&
                types.stream().filter(type -> type == ArmyType.Cavalry).count() >= 1) {
            return 2 * getCavalryTradeValue();
        }

        // If types contains 2 Infantry and 1 Artillery, return 20
        if (types.stream().filter(type -> type == ArmyType.Infantry).count() >= 2 &&
                types.stream().filter(type -> type == ArmyType.Artillery).count() >= 1) {
            return 2 * getArtilleryTradeValue();
        }

        // If types contains 1 Infantry and 2 Cavalry, return 15
        if (types.stream().filter(type -> type == ArmyType.Infantry).count() >= 1 &&
                types.stream().filter(type -> type == ArmyType.Cavalry).count() >= 2) {
            return getCavalryTradeValue() + getArtilleryTradeValue();
        }

        // If types contains 1 Artillery and 2 Cavalry, return 30
        if (types.stream().filter(type -> type == ArmyType.Artillery).count() >= 1 &&
                types.stream().filter(type -> type == ArmyType.Cavalry).count() >= 2) {
            return 3 * getArtilleryTradeValue();
        }

        // return 0 otherwise
        return 0;

    }

}
