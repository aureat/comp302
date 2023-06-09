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
    private boolean attacker;
    private boolean defender;
    private boolean donor;
    private boolean receiver;

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
        owner.addTerritory(this);
    }

    public int getArmies() {
        return armies;
    }

    public void setArmies(int armies) {
        this.armies = armies;
    }

    public void addArmies(int amount) {
        this.armies += amount;
    }

    public void removeArmies(int amount) {
        this.armies -= amount;
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
    public boolean isAttacker(){
        return attacker;
    }

    public boolean isDefender() {
        return defender;
    }

    public void setDefender(boolean defender) {
        this.defender = defender;
    }

    public void setAttacker(boolean attacker) {
        this.attacker = attacker;
    }

    public boolean isReceiver() {
        return receiver;
    }

    public boolean isDonor() {
        return donor;
    }

    public void setReceiver(boolean receiver) {
        this.receiver = receiver;
    }

    public void setDonor(boolean donor) {
        this.donor = donor;
    }
}
