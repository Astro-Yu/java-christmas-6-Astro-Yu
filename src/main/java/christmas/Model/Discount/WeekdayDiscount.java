package christmas.Model.Discount;

import christmas.Constants.Constants;
import christmas.Constants.Menu;
import christmas.Constants.SpecialDays;
import christmas.Model.Day;
import christmas.Model.Order;
import christmas.Model.Orders;
import java.util.List;

public class WeekdayDiscount extends discount {

    private final static int DISCOUNT_PER_MENU = 2_023;

    public WeekdayDiscount(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
        calculateDiscount();

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
                && day.getDate() >= SpecialDays.DEC_1ST.getDate()
                && day.getDate() <= SpecialDays.DEC_31ST.getDate();
    }

    @Override
    public String getEventLog() {
        return String.format(Constants.WEEKDAY_DISCOUNT + discountedPrice + Constants.WON);
    }
}
