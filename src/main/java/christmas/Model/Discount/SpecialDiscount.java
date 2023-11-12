package christmas.Model.Discount;

import christmas.Constants.Constants;
import christmas.Constants.SpecialDays;
import christmas.Model.Day;

public class SpecialDiscount extends discount {
    private final static int specialDiscountValue = 1_000;

    public SpecialDiscount(Day day) {
        this.day = day;
        calculateDiscount();
    }

    @Override
    public void calculateDiscount() {
        discountedPrice = specialDiscountValue;
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }

    @Override
    public boolean isEventActive() {
        return day.isStarDay()
                && day.getDate() >= SpecialDays.DEC_1ST.getDate()
                && day.getDate() <= SpecialDays.DEC_31ST.getDate();
    }

    @Override
    public String getEventLog() {
        return String.format(Constants.SPECIAL_DISCOUNT + discountedPrice + Constants.WON);
    }
}