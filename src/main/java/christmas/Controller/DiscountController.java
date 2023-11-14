package christmas.Controller;

import christmas.Model.Day;
import christmas.Model.Discount.ChristmasDiscount;
import christmas.Model.Discount.GiftEvent;
import christmas.Model.Discount.SpecialDiscount;
import christmas.Model.Discount.WeekdayDiscount;
import christmas.Model.Discount.WeekendDiscount;
import christmas.Model.EventLog;
import christmas.Model.Orders.Orders;
import christmas.Model.PriceBeforeDiscount;

public class DiscountController {

    private final Day day;
    private final Orders orders;

    public DiscountController(Day day, Orders orders) {
        this.day = day;
        this.orders = orders;
    }

    public EventLog setEventLog() {

        return new EventLog(new ChristmasDiscount(day), new GiftEvent(orders, day),
                new SpecialDiscount(day), new WeekdayDiscount(orders, day), new WeekendDiscount(orders, day),
                new PriceBeforeDiscount(orders));
    }
}
