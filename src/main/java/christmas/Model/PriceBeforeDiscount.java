package christmas.Model;

import static christmas.Constants.Menu.CHAMPANGE;

import christmas.Constants.Constants;
import christmas.Model.Orders.Orders;

public class PriceBeforeDiscount {
    private final static int MINIMUM_GIFT_AMOUNT = 120_000;
    private final static int MINIMUM_DISCOUNT_AMOUNT = 10_000;
    private static String gift = Constants.NOTHING;

    private final Orders orders;


    public PriceBeforeDiscount(Orders orders) {
        this.orders = orders;
    }

    public int getPrice() {
        return orders.getTotalPrice();
    }

    public String getGiftMenu() {
        if (over120kWon()) {
            gift = String.format(CHAMPANGE.getName() + " 1개");
        }
        return gift;
    }

    public boolean over10kWon() {
        return orders.getTotalPrice() >= MINIMUM_DISCOUNT_AMOUNT;
    }

    public boolean over120kWon() {
        return orders.getTotalPrice() >= MINIMUM_GIFT_AMOUNT;
    }

}
