package game.player;

import game.Colors;

public class Player {

    private String username;
    private String displayName;
    private Colors.Type color;
    private Avatars.Type avatar;
    private boolean isComputer;

    public Inventory inventory;

    public Player() {
        inventory = new Inventory();
        generateCharacter();
    }

    public Colors.Type getColor() {
        return color;
    }

    public void setColor(Colors.Type color) {
        this.color = color;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Avatars.Type getAvatar() {
        return avatar;
    }

    public void setAvatar(Avatars.Type avatar) {
        this.avatar = avatar;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public void setComputer(boolean computer) {
        isComputer = computer;
    }

    public String getAvatarString() {
        return Avatars.toString(avatar);
    }

    public int getTerritoryCount() {
        return territories.size();
    }

    public int getDraftArmyCount() {
        return Math.min(3, Math.floorDiv(territories.size(), 3));
    }

    public void generateCharacter() {
        this.username = "";
        this.displayName = Names.getRandomName();
        this.color = Colors.getRandomColor();
        this.avatar = Avatars.getRandomCharacter();
    }

}
