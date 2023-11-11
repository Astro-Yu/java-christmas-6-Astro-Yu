package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SpecialDays {
    DEC_1ST(1, false, false),
    DEC_3RD(3, true, false),
    DEC_10TH(10, true, false),
    DEC_17TH(17, true, false),
    DEC_25TH(25, true, true),
    DEC_31ST(31, true, false);

    private final int date;
    private final boolean isStar;
    private final boolean isChristmas;

    SpecialDays(int date, boolean isStar, boolean isChristmas) {
        this.date = date;
        this.isStar = isStar;
        this.isChristmas = isChristmas;
    }

    public static List<Integer> getStarDay() {
        return Arrays.stream(SpecialDays.values())
                .filter(SpecialDays::isStar)
                .map(SpecialDays::getDate)
                .collect(Collectors.toList());
    }

    public static List<Integer> getChristmas() {
        return Arrays.stream(SpecialDays.values())
                .filter(SpecialDays::isChristmas)
                .map(SpecialDays::getDate)
                .collect(Collectors.toList());
    }

    public int getDate() {
        return date;
    }

    private boolean isStar() {
        return isStar;
    }

    private boolean isChristmas() {
        return isChristmas;
    }
}
