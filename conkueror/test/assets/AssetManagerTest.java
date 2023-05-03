package assets;

import org.junit.jupiter.api.Test;
import ui.assets.AssetLoader;

import static org.junit.jupiter.api.Assertions.*;

class AssetManagerTest {

    @Test
    void getImageURL() {
        assertNotNull(AssetLoader.getImageURL("icon/app.png"));
    }

    @Test
    void getImage() {
        assertNotNull(AssetLoader.getImage("icon/app.png"));
    }
}