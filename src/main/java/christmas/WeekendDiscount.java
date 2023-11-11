package christmas;

import java.util.List;

public class WeekendDiscount extends discount {

    private final static int discountPerMenu = 2_023;

    public WeekendDiscount(Orders orders) {
        this.orders = orders;
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

        this.discountedPrice = mainMenuCount * discountPerMenu;
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }
}
