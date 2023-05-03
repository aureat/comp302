package util;

import domain.util.CoreUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoreUtilsTest {

    enum TestEnum {
        NorthAmerica,
        Oceania
    }

    @Test
    void separateOnCapital() {
        assertEquals("North America", CoreUtils.separateOnCapital("NorthAmerica"));
        assertEquals("Oceania", CoreUtils.separateOnCapital("Oceania"));
        assertEquals("North America", CoreUtils.separateOnCapital(TestEnum.NorthAmerica));
        assertEquals("Oceania", CoreUtils.separateOnCapital(TestEnum.Oceania));
    }

}