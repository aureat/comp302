package ui.assets;

import ui.app.Config;

import java.util.HashMap;
import java.util.Map;

public enum Assets {

    AvatarMd("avatars/full", 150, 150),
    AvatarLg("avatars/full", 250, 250),
    AvatarRounded("avatars/rounded", 100, 103),
    Background("backgrounds", Config.preferredWidth, Config.preferredHeight),
    ButtonLg("buttons/lg", 325, 59),
    ButtonSave("buttons/lg", 154, 59),
    ButtonMd("buttons/md", 140, 49),
    ColorBall("colors/ball", 39, 40),
    ColorCard("colors/card", 180, 238),
    ColorCardLg("colors/card", 300, 397),
    InputText("inputs/text", 503, 59),
    ColorFrame("colors/frame"),
    Icon("icon"),
    Logo("logo"),
    MenuMd("menu", 48, 50),
    MenuLg("menu", 57, 59),
    PanelBoard("panel/board"),
    PanelContext("panel/context", 37, 49),
    PanelFloating("panel/floating"),
    PanelDraft("panel/draft"),
    PanelPhases("panel/phases"),
    PanelPhase("panel/phase"),
    AvatarCircular("avatars/circular", 390, 390);



    private final Map<String, Asset> cache = new HashMap<>();

    private final String basePath;
    private final int width;
    private final int height;

    Assets(String basePath) {
        this(basePath, 0, 0);
    }

    Assets(String basePath, int width, int height) {
        this.basePath = basePath;
        this.width = width;
        this.height = height;
    }

    public String getBasePath() {
        return basePath;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPath(String name, String extension) {
        return basePath + "/" + name + "." + extension;
    }

    public String getPath(String name) {
        return getPath(name, "png");
    }

    public void loadAsset(String name) {
        getAsset(name).load();
    }

    public Asset getAsset(String name) {
        if (!cache.containsKey(name)) {
            Asset asset;
            if (width == 0 || height == 0) {
                asset = new Asset(getPath(name));
            } else {
                asset = new Asset(getPath(name), width, height);
            }
            cache.put(name, asset);
            return asset;
        }
        return cache.get(name);
    }

}
