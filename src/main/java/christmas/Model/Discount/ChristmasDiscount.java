package christmas.Model.Discount;

import static christmas.Utils.Utils.numberFormat;

import christmas.Constants.Constants;
import christmas.Constants.SpecialDays;
import christmas.Model.Day;


public class ChristmasDiscount extends Discount {

    private final static int INITIAL_DISCOUNT = 1_000;
    private final static int DISCOUNT_PER_DAY = 100;

    private final Day day;

    public ChristmasDiscount(Day day) {
        this.day = day;
    }

    @Override
    public void calculateDiscount() {
        discountedPrice = INITIAL_DISCOUNT + DISCOUNT_PER_DAY * (day.getDate() - 1);
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }

    @Override
    public boolean isEventActive() {
        return day.getDate() <= SpecialDays.DEC_25TH.getDate();
    }

    @Override
    public String getEventLog() {
        return String.format(
                Constants.CHRISTMAS_DISCOUNT + Constants.MINUS + numberFormat(discountedPrice) + Constants.WON);
    }
}
