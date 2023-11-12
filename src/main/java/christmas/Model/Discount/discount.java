package christmas.Model.Discount;

import christmas.Model.Day;
import christmas.Model.Orders;

public abstract class discount {

    protected int discountedPrice;
    protected Orders orders;
    protected Day day;

    abstract public void calculateDiscount();

    abstract public int getDiscountedValue();

    abstract public boolean isEventActive();

    abstract public String getEventLog();
}
