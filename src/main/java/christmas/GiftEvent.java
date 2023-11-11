package christmas;

public class GiftEvent extends discount {

    public GiftEvent(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
        calculateDiscount();
    }

    @Override
    public void calculateDiscount() {
        discountedPrice = Menu.CHAMPANGE.getPrice();
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
