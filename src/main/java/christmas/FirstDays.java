package christmas;

public enum FirstDays {
    SUN(3),
    MON(4),
    TUE(5),
    WED(6),
    THU(7),
    FRI(1),
    SAT(2);

    private final int firstDayOfDec;

    FirstDays(int firstDayOfDec) {
        this.firstDayOfDec = firstDayOfDec;
    }

    public int getFirstDayOfDec() {
        return this.firstDayOfDec;
    }
}
