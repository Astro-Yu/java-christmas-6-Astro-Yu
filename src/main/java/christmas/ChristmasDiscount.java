package christmas;

public class ChristmasDiscount extends discount {

    private final static int INITIAL_DISCOUNT = 1_000;
    private final static int DISCOUNT_PER_DAY = 100;

    private final Day day;

    public ChristmasDiscount(Day day) {
        this.day = day;
        calculateDiscount();
    }

    @Override
    public void calculateDiscount() {
        discountedPrice = INITIAL_DISCOUNT + DISCOUNT_PER_DAY * day.getDate();
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }

    @Override
    public boolean isEventActive() {
        return day.getDate() <= SpecialDays.DEC_25TH.getDate();
    }
}
