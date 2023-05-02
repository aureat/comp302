package domain.model.map.states;

import domain.model.player.Colors;
import domain.model.player.Player;

public class TerritoryState {

    private Player owner;
    private int armies;
    private boolean playable;

    public TerritoryState() {
        owner = null;
        armies = 0;
        playable = true;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public void addArmies(int amount) {
        this.armies += armies;
    }

    public void removeArmies(int amount) {
        this.armies -= armies;
    }

    public boolean isPlayable() {
        return playable;
    }

    public void setPlayable(boolean playable) {
        this.playable = playable;
    }

    public void togglePlayable() {
        playable = !playable;
    }

    public Colors.ColorType getColor() {
        if (!playable)
            return Colors.unplayable;
        else if (owner == null)
            return Colors.unconquered;
        return owner.getColor();
    }

    public boolean isConquered() {
        return owner != null;
    }

    public boolean canStartAttack() {
        return playable && owner != null && armies > 3;
    }

    public boolean canStartFortify() {
        return playable && owner != null && armies > 1;
    }



}