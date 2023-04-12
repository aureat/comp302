package model.map;

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Label;
import model.player.Colors;
import model.player.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Category("MapInit")
@Description("Represents a single territory on map, points to its neighbors and handles territory state.")
public class Territory {

    private String name;
    private Continent continent;
    private Player owner;
    private List<Territory> neighbors;
    private int armies;
    private boolean isPlayable;

    public Territory(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
        this.owner = null;
        this.neighbors = new ArrayList<>();
        this.armies = 0;
        this.isPlayable = true;
    }

    public String getName() {
        return name;
    }

    public Continent getContinent() {
        return continent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(@NotNull Player newOwner) {
        owner = newOwner;
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int newArmies) {
        armies = newArmies;
    }

    public void incArmies(int amount) {
        armies += amount;
    }

    public void loseOneArmy() {
        armies -= 1;
    }

    public void loseTwoArmies() {
        armies -= 2;
    }

    public boolean hasNeighbor(@NotNull Territory territory) {
        return neighbors.contains(territory);
    }

    public boolean isOwnedBy(Player player) {
        return owner.equals(player);
    }

    public void addNeighbor(@NotNull Territory territory) {
        neighbors.add(territory);
    }

    public void addNeighbors(@NotNull Territory...territories) {
        for (Territory territory : territories)
            addNeighbor(territory);
    }

    public List<Territory> getAllNeighbors() {
        return neighbors;
    }

    public boolean canStartAttack() {
        return armies > 3;
    }

    public List<Territory> getAttackableNeighbors() {
        List<Territory> list = new ArrayList<>(neighbors);
        return list.stream().filter(t -> !t.isOwnedBy(owner) && t.getArmies() < armies).toList();
    }

    public Colors.ColorType getColor() {
        if (!isPlayable)
            return Colors.unplayable;
        else if (owner == null)
            return Colors.unconquered;
        return owner.getColor();
    }

}
