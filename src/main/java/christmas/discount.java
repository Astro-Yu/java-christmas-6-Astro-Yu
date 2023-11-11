package christmas;

public abstract class discount {

    protected int discountedPrice;
    protected Orders orders;

    abstract public void calculateDiscount();

    abstract public int getDiscountedValue();
}
