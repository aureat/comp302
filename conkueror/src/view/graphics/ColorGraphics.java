package view.graphics;

import domain.model.player.Colors;

import java.awt.*;
import java.util.HashMap;

public class ColorGraphics {

    public static class Palette {

        private Color territoryDisabled;
        private Color territoryDefault;
        private Color territoryHovered;
        private Color territorySelected;
        private Color continentDisabled;
        private Color continentDefault;
        private Color continentHovered;
        private Color continentSelected;

        public Palette(Color territoryDisabled,
                       Color territoryDefault,
                       Color territoryHovered,
                       Color territorySelected,
                       Color continentDisabled,
                       Color continentDefault,
                       Color continentHovered,
                       Color continentSelected)
        {
            this.territoryDisabled = territoryDisabled;
            this.territoryDefault = territoryDefault;
            this.territoryHovered = territoryDefaultHover;
            this.territorySelected = territorySelected;
            this.territorySelectedHover = territorySelectedHover;
            this.continentDisabled = continentDisabled;
            this.continentDefault = continentDefault;
            this.continentHovered = continentHovered;
            this.continentSelected = continentSelected;
        }

    }

    public static HashMap<Colors.ColorType, Palette> paletteMap = new HashMap<>();

    public ColorGraphics() {
        initPalettes();
    }

    public void initPalettes() {

        Palette yellow = new Palette(
                new Color(113, 92, 14),
                new Color(168, 147, 69),
                new Color(255, 255, 0),
                new Color(254, 195, 39),
                new Color(255, 255, 0),
                new Color(255, 255, 0),
                new Color(255, 255, 0),
                new Color(255, 255, 0)
        );
        paletteMap.put(Colors.ColorType.Yellow, yellow);

    }

}
