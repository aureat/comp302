package model.game;

import model.army.ArmyType;
import model.map.Territory;
import model.player.Player;
import model.card.TerritoryCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TerritoryState {
    private int armyNumber ;
    private Player owner ;
    private TerritoryCard territoryCard;
    private boolean isPlaylable;
    private List<Territory> neighbors;
    private int armies ; // TEMPORARY ARMY COUNTER



    public boolean isOwnedBy(Player player) {
        return owner.equals(player);
    }


    public boolean canStartAttack() {
        return armies > 3;
    }

    public List<Territory> getAttackableNeighbors() {
        List<Territory> list = new ArrayList<>(neighbors);
        return list.stream().filter(t -> !t.isOwnedBy(owner) && t.getArmies() < armies).toList();
    }

    public int getArmyNumber() {
        return armyNumber;
    }

    public void setArmyNumber(int armyNumber) {
        this.armyNumber = armyNumber;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public TerritoryCard getTerritoryCard() {
        return territoryCard;
    }

    public void setTerritoryCard(TerritoryCard territoryCard) {
        this.territoryCard = territoryCard;
    }

    public boolean isPlaylable() {
        return isPlaylable;
    }

    public void setPlaylable(boolean playlable) {
        isPlaylable = playlable;
    }

    public void increaseArmyNumber(ArmyType armyType) {
        if (armyType.getName().equals("Infantry")){
            armies ++;
        }
        if (armyType.getName().equals("Cavalry")){
            armies += 5;
        }
        if (armyType.getName().equals("Artillery")){
            armies += 10;
        }
    }
}
