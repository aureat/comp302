package domain.maps;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClassicMapTest {

    @Test
    public void testClassicMapInformation() {
        ClassicMap classicMap = new ClassicMap();
        classicMap.createMap();
        assertNotNull(classicMap.getName());
        assertNotNull(classicMap.getDescription());
    }

    @Test
    public void testClassicMapTerritories() {
        ClassicMap classicMap = new ClassicMap();
        classicMap.createMap();
        assertNotNull(classicMap.getTerritories());
        assertNotNull(classicMap.getContinents());
        assertEquals(39, classicMap.getTerritories().size());
        assertEquals(6, classicMap.getContinents().size());
    }

}