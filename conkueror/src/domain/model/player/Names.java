package domain.model.player;

import domain.model.game.Utils;

public class Names {

    private static String[] names = {
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

    public static String getRandom() {
        return Utils.randomChoice(names);
    }

}
