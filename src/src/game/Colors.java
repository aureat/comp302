package game;

import game.map.Territory;
import game.player.Avatars;
import game.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Colors {

    public enum Type {
        ORANGE,
        BLUE,
        GREEN,
        RED,
        PURPLE,
        YELLOW,
        CYAN,
        PINK,
        LIGHT_BLUE,
        GRAY,
        LIGHT,
    }

    public static final Type unconquered = Type.LIGHT;
    public static final Type unplayable = Type.GRAY;

    public static String getString(Type color) {
        return color.toString();
    }

    public static List<Type> getPlayerColors() {
        List<Type> list = new ArrayList<>(Arrays.asList(Type.values()));
        list.remove(unconquered);
        list.remove(unplayable);
        return list;
    }

    public static List<Type> getAllColors() {
        return new ArrayList<>(Arrays.asList(Type.values()));
    }

    public static Type getRandomColor() {
        Colors.Type[] colors = Colors.Type.values();
        Random random = new Random();
        return colors[random.nextInt(colors.length)];
    }

    public static Type getTerritoryColor(Territory territory) {
        return territory.getColor();
    }

    public static Type getPlayerColor(Player player) {
        return player.getColor();
    }

}
