package christmas.Model;

import static christmas.Constants.Constants.ONE_WEEK;
import static christmas.Constants.ErrorMessages.INVALID_DATE_RANGE;
import static christmas.Constants.SpecialDays.DEC_1ST;
import static christmas.Constants.SpecialDays.DEC_31ST;

import christmas.Constants.FirstDays;
import christmas.Constants.SpecialDays;
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
        return date % ONE_WEEK == FirstDays.FRI.getFirstDayOfDec()
                || date % ONE_WEEK == FirstDays.SAT.getFirstDayOfDec();
    }

    public boolean isStarDay() {
        List<Integer> starDay = SpecialDays.getStarDay();
        return starDay.contains(date);
    }

    private void validate() {
        isProperRange();
    }

    private void isProperRange() {
        if (date < DEC_1ST.getDate()
                || date > DEC_31ST.getDate()) {
            throw new IllegalArgumentException(INVALID_DATE_RANGE.getMessage());
        }
    }
}
