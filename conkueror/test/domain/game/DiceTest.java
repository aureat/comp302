package domain.game;

import org.junit.jupiter.api.Test;

import java.util.Random;
//import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {


    private Dice dice =new Dice();

    @Test
    public void testRoll() {
        for (int i = 0; i < 999; i++) {
            int result = dice.roll();
            assertTrue(result >0 && result <7,"True");
        }
    }


















    //    @Test
//    void testroll() {
//        int result = dice.roll();
//        switch (result){
//            case 1 -> assertEquals(1,result);
//            case 2 -> assertEquals(2,result);
//            case 3 -> assertEquals(3,result);
//            case 4 -> assertEquals(4,result);
//            case 5 -> assertEquals(5,result);
//            case 6 -> assertEquals(6,result);
//
//        }
//
//    }

}
