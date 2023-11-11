package christmas;

import static christmas.Menu.CHAMPANGE;

public class PriceBeforeDiscount {
    private final static int MINIMUM_GIFT_AMOUNT = 120_000;
    private final static int MINIMUM_DISCOUNT_AMOUNT = 10_000;

    private final int price;
    private static String gift = Constants.NOTHING;

    public PriceBeforeDiscount(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getGiftMenu() {
        if (over120kWon()) {
            gift = String.format(CHAMPANGE.getName() + " 1개");
        }
        return gift;
    }

    public boolean over10kWon() {
        return price >= MINIMUM_DISCOUNT_AMOUNT;
    }

    private boolean over120kWon() {
        return price >= MINIMUM_GIFT_AMOUNT;
    }

}
