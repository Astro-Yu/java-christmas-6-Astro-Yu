package christmas;

public abstract class discount {

    protected int discountedPrice;
    protected Orders orders;
    protected Day day;

    abstract public void calculateDiscount();

    abstract public int getDiscountedValue();

    abstract public boolean isEventActive();
}
