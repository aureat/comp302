package domain.game;

import domain.game.config.GameConfig;
import domain.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Dice {

    private static final int sides = GameConfig.get().getDiceSides();
    private static final int defaultBias = GameConfig.get().getDefaultDiceBias();
    private static final double rollOneWeight = GameConfig.get().getRollOneBiasWeight();
    private static final double rollTwoWeight = GameConfig.get().getRollTwoBiasWeight();

    private Player attacker;
    private Player defender;
    private boolean hasWon = false;
    private int bias = defaultBias;

    public Dice() {}

    public void setPlayers(@NotNull Player attacker, @NotNull Player defender) {
        this.attacker = attacker;
        this.defender = defender;
        this.hasWon = false;
        this.bias = defaultBias;
    }

    private int roll() {
        return new Random().nextInt(sides) + 1;
    }

    private int rollBiased(double weight) {
        int biasedSides = (int) Math.floor(sides - weight);
        return (int) Math.ceil(new Random().nextInt(biasedSides) + weight + 1);
    }

    public int rollAttacker() {
        if (attacker.canRollTwice()) {
            double weight = bias * rollTwoWeight;
            return rollBiased(weight) + rollBiased(weight);
        }
        double weight = bias * rollOneWeight;
        return rollBiased(weight);
    }

    public int rollDefender() {
        return roll();
    }

    public boolean hasWon() {
        return hasWon;
    }

    public Player decideWinner() {

        // roll for both players
        int attackerDieValue = rollAttacker();
        int defenderDieValue = rollDefender();

        // in case of a tie, the defender wins
        // increase bias to favor the attacker in case of a win
        if (attackerDieValue > defenderDieValue) {
            bias++;
            hasWon = true;
            return attacker;
        }

        // decrease bias to favor the defender in case of a loss
        bias--;
        hasWon = false;
        return defender;

    }

}
