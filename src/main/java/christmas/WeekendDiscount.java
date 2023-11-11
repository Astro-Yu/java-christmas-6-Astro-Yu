package christmas;

import java.util.List;

public class WeekendDiscount extends discount {

    private final static int DISCOUNT_PER_MENU = 2_023;

    public WeekendDiscount(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
        calculateDiscount();
    }

    @Override
    public void calculateDiscount() {
        int mainMenuCount = 0;
        List<Order> orderedItems = orders.getOrderedItems();
        mainMenuCount = orderedItems.stream()
                .filter(x -> Menu.getMainMenu().contains(x.getName()))
                .mapToInt(Order::getCount)
                .sum();

        this.discountedPrice = mainMenuCount * DISCOUNT_PER_MENU;
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
