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

    private final List<TerritoryState> territories = new ArrayList<>();

    protected Player() {
        generateCharacter();
    }

    public List<TerritoryState> getTerritories() {
        return territories;
    }

    public int getTerritoryCount() {
        return territories.size();
    }

    public void addTerritory(TerritoryState territory) {
        territories.add(territory);
    }

    public void removeTerritory(TerritoryState territory) {
        territories.remove(territory);
    }

    public boolean hasTerritory(TerritoryState territory) {
        return territories.contains(territory);
    }

    public void generateCharacter() {
        setColor(Colors.getRandomPlayable());
        setName(Names.getRandom());
        setAvatar(Avatars.getRandom());
        setComputer(Math.random() < 0.5);
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

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public boolean equals(Player other) {
        return this == other;
    }

}
