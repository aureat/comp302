package domain.mapstate;

import domain.gamemap.ContinentType;
import domain.gamemap.TerritoryType;
import domain.player.Colors;
import domain.player.Player;

import java.util.List;

public class TerritoryState {

    private TerritoryType territoryType;

    private Player owner;
    private int armies;
    private boolean playable;

    public TerritoryState(TerritoryType territoryType) {
        this.territoryType = territoryType;
        owner = null;
        armies = 0;
        playable = true;
    }


    public TerritoryType getTerritoryType() {
        return territoryType;
    }

    public ContinentType getContinent() {
        return territoryType.getContinent();
    }

    public String getName() {
        return territoryType.getName();
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

    public void decArmies(int amount) {
        this.armies -= armies;
    }

    public void incArmies(int amount) {
        this.armies += armies;
    }
}
