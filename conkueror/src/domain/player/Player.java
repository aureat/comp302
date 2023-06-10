package domain.player;

import domain.mapstate.TerritoryState;
import org.jetbrains.annotations.NotNull;
import domain.util.CoreUtils;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String fullName;
    private String firstName;
    private Colors.ColorType color;
    private Avatars.AvatarType avatar;
    private boolean isComputer;

    public int getNumberOfTerritories() {
        return numberOfTerritories;
    }

    public void setNumberOfTerritories(int numberOfTerritories) {
        this.numberOfTerritories = numberOfTerritories;
    }

    public void increaseNumberOfTerritories(){
        this.numberOfTerritories++;
    }

    private int numberOfTerritories;

    private List<TerritoryState> territories = new ArrayList<>();

    public Player() {
        generateCharacter();
    }

    public void generateCharacter() {
        setColor(Colors.getRandomPlayable());
        setName(Names.getRandom());
        setAvatar(Avatars.getRandom());
    }

    public Colors.ColorType getColor() {
        return color;
    }

    public void setColor(@NotNull Colors.ColorType color) {
        this.color = color;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setName(@NotNull String displayName) {
        this.fullName = displayName;
        this.firstName = CoreUtils.firstWord(displayName);
    }

    public Avatars.AvatarType getAvatar() {
        return avatar;
    }

    public String getAvatarString() {
        return Avatars.getAvatarName(avatar);
    }

    public void setAvatar(@NotNull Avatars.AvatarType avatar) {
        this.avatar = avatar;
    }

    public void addTerritory(TerritoryState territory) {
        territories.add(territory);
    }

    public List<TerritoryState> getTerritories() {
        return territories;
    }

    public void removeTerritory(TerritoryState territory) {
        territories.remove(territory);
    }

    public boolean hasTerritory(TerritoryState territory) {
        return territories.contains(territory);
    }

    public int getTerritoryCount() {
        return territories.size();
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(@NotNull boolean computer) {
        isComputer = computer;
    }

    public boolean equals(Player other) {
        return this == other;
    }

}
