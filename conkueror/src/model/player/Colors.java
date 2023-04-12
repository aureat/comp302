package model.player;

import model.game.Utils;
import org.jetbrains.annotations.NotNull;

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

    public static String getColorName(@NotNull ColorType color) {
        return color.toString();
    }

    public static ColorType getRandomPlayable() {
        return Utils.randomChoice(playableColors);
    }

}
