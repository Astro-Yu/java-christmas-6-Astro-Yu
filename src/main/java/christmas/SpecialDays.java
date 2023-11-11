package christmas;

public enum SpecialDays {
    DEC3RD(true, false),
    DEC10TH(true, false),
    DEC17TH(true, false),
    DEC24TH(true, true),
    DEC31ST(true, false);

    private final boolean isStar;
    private final boolean isChristmas;

    SpecialDays(boolean isStar, boolean isChristmas) {
        this.isStar = isStar;
        this.isChristmas = isChristmas;
    }
}
