package christmas;

public enum FirstDays {
    SUN(3,false),
    MON(4,false),
    TUE(5,false),
    WED(6,false),
    THU(7,false),
    FRI(1,true),
    SAT(2,true);

    private final int firstDayOfDec;
    private final boolean isWeekend;

    FirstDays(int firstDayOfDec, boolean isWeekend) {
        this.firstDayOfDec = firstDayOfDec;
        this.isWeekend = isWeekend;
    }
}
