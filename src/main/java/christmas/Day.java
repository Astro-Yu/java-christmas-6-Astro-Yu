package christmas;

import static christmas.ErrorMessages.INVALID_DATE_RANGE;

public class Day {

    private final int date;

    public Day(int date) {
        this.date = date;
        validate();
    }

    public int getDate() {
        return date;
    }

    public boolean isWeekend() {
        return date % 7 == FirstDays.FRI.getFirstDayOfDec()
                || date % 7 == FirstDays.SAT.getFirstDayOfDec();
    }

    private void validate() {
        isProperRange();
    }

    private void isProperRange() {
        if (date < 1 || date > 31) {
            throw new IllegalArgumentException(INVALID_DATE_RANGE.getMessage());
        }
    }
}
