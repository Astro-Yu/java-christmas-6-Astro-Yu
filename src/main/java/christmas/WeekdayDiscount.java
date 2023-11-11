package christmas;

import java.util.List;

public class WeekdayDiscount extends discount {

    private final static int DISCOUNT_PER_MENU = 2_023;

    public WeekdayDiscount(Orders orders, Day day) {
        this.orders = orders;
        this.day = day;
        if (!day.isWeekend()) {
            calculateDiscount();
        }
    }

    @Override
    public void calculateDiscount() {
        int desertMenuCount = 0;
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
        return day.getDate() >= SpecialDays.DEC_1ST.getDate()
                && day.getDate() <= SpecialDays.DEC_31ST.getDate();
    }
}
