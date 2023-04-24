package domain.model.player;

import util.CoreUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Avatars {
    public enum AvatarType {
        AfricanFemale,
        AfricanMale,
        ArabicFemale,
        ArabicMale,
        AsianFemale,
        AsianMale,
        BritishFemale,
        BritishMale,
        ChineseFemale,
        ChineseMale,
        EgyptianFemale,
        EgyptianMale,
        EuropeanFemale,
        EuropeanMale,
        GreekMale,
        GreekFemale,
        MedievalFemale,
        MedievalMale,
        NativeFemale,
        NativeMale,
        NinjaFemale,
        NinjaMale,
        PersianFemale,
        PersianMale,
        SamuraiFemale,
        SamuraiMale,
        VikingFemale,
        VikingMale
    }

    public static AvatarType[] array = AvatarType.values();

    private static List<AvatarType> getAll() {
        return new ArrayList<>(Arrays.asList(array));
    }

    private static List<AvatarType> getMales() {
        List<AvatarType> list = getAll();
        list.removeIf(a -> !a.toString().contains("Male"));
        return list;
    }

    private static List<AvatarType> getFemales() {
        List<AvatarType> list = getAll();
        list.removeIf(a -> !a.toString().contains("Female"));
        return list;
    }

    public static List<AvatarType> all = getAll();
    public static List<AvatarType> males = getMales();
    public static List<AvatarType> females = getFemales();

    public static String getAvatarName(@NotNull AvatarType avatar) {
        return avatar.toString();
    }

    public static AvatarType getRandom() {
        return CoreUtils.chooseRandom(all);
    }

    public static AvatarType getRandomMale() {
        return CoreUtils.chooseRandom(males);
    }

    public static AvatarType getRandomFemale() {
        return CoreUtils.chooseRandom(females);
    }

}
