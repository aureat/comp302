package domain.player;

import domain.util.CoreUtils;

public class Names {

    //changing for simplicity while testing (sorry currently using so many print statemenst to find bugs :D
    private static String[] names = {
            "Player One",
            "Player Two",
            "Player Three",
            "Player Four",
            "Player Five",
            "Player Six",
            "Mert :D",

    };

    public static String getRandom() {
        return CoreUtils.chooseRandom(names);
    }

}
