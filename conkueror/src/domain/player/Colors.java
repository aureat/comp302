package domain.player;

import domain.util.CoreUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static final List<ColorType> playableColorsList = new ArrayList<>(Arrays.asList(playableColors));

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
        return CoreUtils.chooseRandom(playableColors);
    }

}
