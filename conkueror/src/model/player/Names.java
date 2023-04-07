package model.player;

import java.util.Random;

public class Names {

    private static String[] displayNames = {
            "Sans Betancur",
            "Célia Picazo",
            "Pili Oquendo",
            "Wiebke Esser",
            "Romey Walter",
            "Helmine Waltz",
            "Zou Shunyuan",
            "Cai Xia",
            "Xiong Xiang",
            "Rhian Pritchett",
            "Eiluned Nanney",
            "Asuman Çalik",
            "Burçin Kayhan",
            "Yaromir Orlov",
            "Zhanna Aleksandrova",
            "Tashiro Haru",
            "Wada Ko",
            "Sanda Jurou",
            "Zoé Dufour",
            "Pierrette Olivier",
            "Jean Villeneuve",
            "Sandhya Trivedi",
            "Anuj Parikh",
            "Chu Eun Sun",
            "Zephyrinus Sacerdos",
            "Sisera Clodianus",
            "Raha Ammar",
            "Aswad Kader",
            "Irene Parham",
            "Frank Baldwin",
            "Ike Byrd",
            "Hadwig Dreschnerg",
            "Stígandr Farnhame",
            "Democritus Corculum",
            "Darya Morozova",
            "Klavdiya Smirnova",
            "Tasha Fedorova",
            "Yaropolk Kozlov"
    };

    public static String getRandomName() {
        Random random = new Random();
        return displayNames[random.nextInt(displayNames.length)];
    }

}
