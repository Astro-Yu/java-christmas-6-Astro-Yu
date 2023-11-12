package christmas.Model.Discount;

import christmas.Model.Day;
import christmas.Model.Orders;
import christmas.Model.PriceBeforeDiscount;

public abstract class Discount {

    protected int discountedPrice;
    protected Orders orders;
    protected Day day;
    protected PriceBeforeDiscount priceBeforeDiscount;

    abstract public void calculateDiscount();

    abstract public int getDiscountedValue();

    abstract public boolean isEventActive();

    abstract public String getEventLog();
}
