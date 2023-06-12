package ui.graphics.color;

import domain.player.Colors;

import java.awt.*;
import java.util.HashMap;

public class ColorGraphics {

    private final static HashMap<Colors.ColorType, Palette> paletteMap = new HashMap<>();

    public static void definePalette(Colors.ColorType color, Color bright, Color dark, Color darker) {
        paletteMap.put(color, new Palette(bright, dark, darker));
    }

    public static Palette getPalette(Colors.ColorType color) {
        return paletteMap.get(color);
    }

    public static void initPalettes() {

        definePalette(Colors.ColorType.Yellow, new Color(254, 195, 39), new Color(194, 155, 50), new Color(122, 91, 0));
        definePalette(Colors.ColorType.Red, new Color(248, 74, 76), new Color(141, 47, 47), new Color(72, 19, 18));
        definePalette(Colors.ColorType.Orange, new Color(252, 133, 32), new Color(142, 96, 44), new Color(140, 71, 18));
        definePalette(Colors.ColorType.Green, new Color(130, 255, 58), new Color(73, 123, 62), new Color(61, 75, 0));
        definePalette(Colors.ColorType.Blue, new Color(38, 167, 255), new Color(53, 105, 129), new Color(16, 54, 84));
        definePalette(Colors.ColorType.Purple, new Color(158, 80, 255), new Color(64, 43, 74), new Color(54, 40, 82));

        definePalette(Colors.ColorType.Gray,
                new Color(0xCAD3E1),
                new Color(0x838C9B),
                new Color(0x585E65)
        );

    }

    static {
        initPalettes();
    }

}
