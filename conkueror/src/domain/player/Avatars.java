package domain.player;

import domain.util.CoreUtils;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Avatars {

    public enum AvatarType {
        AfricanFemale,
        AfricanMale,
        ArabicFemale,
        ArabicMale,
        AsianFemale,
        AsianMale,
        AttilaMale,
        BritishFemale,
        BritishMale,
        ChineseFemale,
        ChineseMale,
        DamlaFemale,
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

    public static final List<AvatarType> all = getAll();
    public static final List<AvatarType> males = getAll("Male");
    public static final List<AvatarType> females = getAll("Female");

    public static List<AvatarType> avatarCache;

    protected static void initialize() {
        avatarCache = new ArrayList<>(all);
        Collections.shuffle(avatarCache);
    }

    private static List<AvatarType> getAll() {
        return new ArrayList<>(Arrays.asList(AvatarType.values()));
    }

    private static List<AvatarType> getAll(String keyword) {
        return getAll().stream().filter(a -> a.toString().contains(keyword)).toList();
    }

    public static String getAvatarName(@NotNull AvatarType avatar) {
        return avatar.toString();
    }

    public static AvatarType getRandom() {
        AvatarType randomAvatar = CoreUtils.chooseRandom(avatarCache);
        avatarCache.remove(randomAvatar);
        return randomAvatar;
    }

}
