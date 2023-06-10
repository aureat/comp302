package domain.player;

import domain.util.CoreUtils;
import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {

    private static final String[] names = {
            "Sans Betancur",
            "Célia Picazo",
            "Pili Oquendo",
            "Wiebke Esser",
            "John C. Ock",
            "Romey Walter",
            "Ben Dover",
            "Mike Hunt",
            "Helmine Waltz",
            "Zou Shunyuan",
            "Cai Xia",
            "Xiong Xiang",
            "Rhian Pritchett",
            "Eiluned Nanney",
            "Asuman Çalik",
            "Burçin Kayhan",
            "Yaromir Orlov",
            "Yuri Nate",
            "Zhanna Aleksandrova",
            "Tashiro Haru",
            "Wada Ko",
            "Dang Lee Wang",
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
            "Ann Al",
            "Aswad Kader",
            "Irene Parham",
            "Frank Baldwin",
            "Ike Byrd",
            "Vye Agra",
            "Hadwig Dreschnerg",
            "Stígandr Farnhame",
            "Democritus Corculum",
            "Darya Morozova",
            "Klavdiya Smirnova",
            "Tasha Fedorova",
            "Yaropolk Kozlov",
            "Sevim Adivar",
            "Lanzo Böhm",
            "Bamber Southers",
            "Anselma Knopf",
            "Banou Ibori",
            "Zahra Ezekwesili",
            "Malini Char",
            "Khashifa Badour",
            "Zeno Lactuca",
            "Hermanus Clineas",
            "Agapius Salvitto",
            "Eoforhild Airaldii",
            "Payton Cartwrighte",
            "Dubhthach O'Byrnei",
            "Gluteus Maximus",
            "Naomh O'Keefei",
            "Fíona Finnini",
            "Annveig Ketil",
            "Adalsteinn Valkyrie",
            "Unrne Birger",
            "Ulrandir Nharimlur",
            "Keezheekoni Miwok",
            "Kele Hopi",
            "Pitalesharo Pawnee",
            "Cheveyo Hopi"
    };

    public static List<String> nameCache;

    protected static void initialize() {
        nameCache = new ArrayList<>(Arrays.asList(names));
        Collections.shuffle(nameCache);
    }

    public static String getRandom() {
        String randomName = CoreUtils.chooseRandom(names);
        nameCache.remove(randomName);
        return randomName;
    }

}
