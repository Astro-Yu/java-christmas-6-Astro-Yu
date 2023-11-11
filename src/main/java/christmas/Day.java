package christmas;

import static christmas.ErrorMessages.INVALID_DATE_RANGE;

import java.util.List;

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

    public boolean isStarDay() {
        List<Integer> starDay = SpecialDays.getStarDay();
        return starDay.contains(date);
    }

    public boolean isChristmas() {
        List<Integer> christmas = SpecialDays.getChristmas();
        return christmas.contains(date);
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
