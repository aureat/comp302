package assets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AssetsTest {

    @Test
    void getImageURL() {
        assertNotNull(Assets.getImageURL("icon/app.png"));
    }

    @Test
    void getImage() {
        assertNotNull(Assets.getImage("icon/app.png"));
    }
}