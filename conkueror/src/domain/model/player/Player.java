package domain.model.player;


import org.jetbrains.annotations.NotNull;

public class Player {

    private String fullName;
    private String firstName;
    private Colors.ColorType color;
    private Avatars.AvatarType avatar;
    private boolean isComputer;

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
        this.firstName = displayName.split(" ")[0];
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

    public void setComputer(@NotNull boolean computer) {
        isComputer = computer;
    }

    public boolean equals(Player other) {
        return this == other;
    }

}
