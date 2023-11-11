package christmas;

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
        return day.getDate() >= SpecialDays.DEC_1ST.getDate()
                && day.getDate() <= SpecialDays.DEC_31ST.getDate();
    }
}
