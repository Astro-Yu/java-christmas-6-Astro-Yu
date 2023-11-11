package christmas;

public class PriceBeforeDiscount {
    private final static int MINIMUM_GIFT_AMOUNT = 120_000;
    private final static int MINIMUM_DISCOUNT_AMOUNT = 10_000;

    private final int price;

    public PriceBeforeDiscount(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean over120kWon() {
        return price >= MINIMUM_GIFT_AMOUNT;
    }

    public boolean over10kWon() {
        return price >= MINIMUM_DISCOUNT_AMOUNT;
    }

}
