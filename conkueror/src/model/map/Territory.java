package game.map;

import game.Colors;
import game.player.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class Territory {

    private String name;
    private Continent continent;
    private Player owner;
    private ArrayList<Territory> adjacentTerritories;
    private HashMap<ArmyType, Integer> armies;
    private boolean isPlayable;

    public Territory(String name, Continent continent) {
        this.name = name;
        this.continent = continent;
    }

    public Colors.Type getColor() {
        if (!isPlayable)
            return Colors.unplayable;
        else if (owner == null)
            return Colors.unconquered;
        return owner.getColor();
    }

}
