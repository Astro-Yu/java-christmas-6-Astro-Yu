package christmas;

import java.util.List;

public class WeekdayDiscount extends discount {

    public WeekdayDiscount(Orders orders) {
        this.orders = orders;
        calculateDiscount();
    }

    @Override
    public void calculateDiscount() {
        int desertMenuCount = 0;
        List<Order> orderedItems = orders.getOrderedItems();
        desertMenuCount = orderedItems.stream()
                .filter(x -> Menu.getDesertMenu().contains(x.getName()))
                .mapToInt(Order::getCount)
                .sum();

        this.discountedPrice = desertMenuCount * discountPerMenu;
    }

    @Override
    public int getDiscountedValue() {
        return discountedPrice;
    }
}
