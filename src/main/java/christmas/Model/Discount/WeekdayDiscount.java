package christmas.Model.Discount;

import static christmas.Constants.SpecialDays.DEC_1ST;
import static christmas.Constants.SpecialDays.DEC_31ST;
import static christmas.Utils.Utils.numberFormat;

import christmas.Constants.Constants;
import christmas.Constants.Menu;
import christmas.Model.Day;
import christmas.Model.Orders.Order;
import christmas.Model.Orders.Orders;
import java.util.List;

public class WeekdayDiscount extends Discount {

    private final static int DISCOUNT_PER_MENU = 2_023;

    public WeekdayDiscount(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
    }

    @Override
    public void calculateDiscount() {
        int desertMenuCount;
        List<Order> orderedItems = orders.getOrderedItems();
        desertMenuCount = orderedItems.stream()
                .filter(x -> Menu.getDesertMenu().contains(x.getName()))
                .mapToInt(Order::getCount)
                .sum();

        this.discountedPrice = desertMenuCount * DISCOUNT_PER_MENU;
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }

    @Override
    public boolean isEventActive() {
        return !day.isWeekend()
                && day.getDate() >= DEC_1ST.getDate()
                && day.getDate() <= DEC_31ST.getDate();
    }

    @Override
    public String getEventLog() {
        return String.format(
                Constants.WEEKDAY_DISCOUNT + Constants.MINUS + numberFormat(discountedPrice) + Constants.WON);
    }
}
