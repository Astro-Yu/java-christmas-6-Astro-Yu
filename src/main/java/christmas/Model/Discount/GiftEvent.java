package christmas.Model.Discount;

import static christmas.Utils.Utils.numberFormat;

import christmas.Constants.Constants;
import christmas.Constants.Menu;
import christmas.Constants.SpecialDays;
import christmas.Model.Day;
import christmas.Model.Orders.Orders;

public class GiftEvent extends Discount {

    public GiftEvent(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
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

    @Override
    public String getEventLog() {
        return String.format(Constants.GIFT_EVENT + Constants.MINUS + numberFormat(discountedPrice) + Constants.WON);
    }
}
