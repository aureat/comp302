package game.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Avatars {
    public enum Type {
        AfricanFemale,
        AfricanMale,
        ArabicFemale,
        ArabicMale,
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

    public static String toString(Type avatar) {
        return avatar.toString();
    }

    public static Type getRandomCharacter() {
        Type[] avatars = Type.values();
        Random random = new Random();
        return avatars[random.nextInt(avatars.length)];
    }

    public static List<Type> getAllCharacters() {
        return new ArrayList<>(Arrays.asList(Type.values()));
    }

    public static List<Type> getMaleCharacters() {
        List<Type> list = new ArrayList<>(Arrays.asList(Type.values()));
        list.removeIf(a -> !a.toString().contains("Male"));
        return list;
    }

    public static List<Type> getFemaleCharacters() {
        List<Type> list = new ArrayList<>(Arrays.asList(Type.values()));
        list.removeIf(a -> !a.toString().contains("Female"));
        return list;
    }

}
