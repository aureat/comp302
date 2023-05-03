package ui.assets;

import javax.swing.*;
import java.awt.*;
import java.io.InputStream;

public class Fonts {

    public static Font defaultFont = new JLabel().getFont();
    public static Font GilroyBold;
    public static Font GilroyExtraBold;

    public static void register() {
        GilroyBold = createFont("GilroyBold");
        GilroyExtraBold = createFont("GilroyExtraBold");
    }

    public static Font createFont(String name) {
        try {
            InputStream is = Fonts.class.getResourceAsStream("/fonts/" + name + ".ttf");
            if (is == null) {
                return defaultFont;
            }
            return Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
