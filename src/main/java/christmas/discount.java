package christmas;

public abstract class discount {
    protected final static int discountPerMenu = 2_023;
    protected int discountedPrice;
    protected Orders orders;

    abstract public void calculateDiscount();

    abstract public int getDiscountedValue();
}
