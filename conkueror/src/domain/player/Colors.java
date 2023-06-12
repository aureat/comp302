package domain.player;

import util.CoreUtils;

import java.util.*;

public class Colors {

    public enum ColorType {
        Yellow,
        Green,
        Purple,
        Red,
        Orange,
        Blue,
        Gray,
        Light,
    }

    public static final ColorType unconquered = ColorType.Light;
    public static final ColorType unplayable = ColorType.Gray;

    public static final ColorType[] playableColors = {
            ColorType.Yellow,
            ColorType.Green,
            ColorType.Purple,
            ColorType.Red,
            ColorType.Orange,
            ColorType.Blue
    };

    public static List<ColorType> playableCache;

    protected static void initialize() {
        playableCache = new ArrayList<>(Arrays.asList(playableColors));
        Collections.shuffle(playableCache);
    }

    public static String getColorName(ColorType color) {
        return color.toString();
    }

    public static String getAssetName(ColorType color) {
        return getColorName(color).toLowerCase();
    }

    public static ColorType getColorType(String color) {
        String name = color.toLowerCase().replace(" ", "");
        return ColorType.valueOf(name.substring(0, 1).toUpperCase() + name.substring(1));
    }

    public static ColorType getRandomPlayable() {
        ColorType randomColor = CoreUtils.chooseRandom(playableCache);
        playableCache.remove(randomColor);
        return randomColor;
    }

}
