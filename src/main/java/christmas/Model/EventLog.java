package christmas.Model;

import christmas.Constants.Constants;
import christmas.Model.Discount.ChristmasDiscount;
import christmas.Model.Discount.GiftEvent;
import christmas.Model.Discount.SpecialDiscount;
import christmas.Model.Discount.WeekdayDiscount;
import christmas.Model.Discount.WeekendDiscount;
import java.util.ArrayList;
import java.util.List;

public class EventLog {
    ChristmasDiscount christmasDiscount;
    GiftEvent giftEvent;
    SpecialDiscount specialDiscount;
    WeekdayDiscount weekdayDiscount;
    WeekendDiscount weekendDiscount;
    PriceBeforeDiscount priceBeforeDiscount;

    List<String> eventHistory = new ArrayList<>();

    public EventLog(ChristmasDiscount christmasDiscount, GiftEvent giftEvent, SpecialDiscount specialDiscount,
                    WeekdayDiscount weekdayDiscount, WeekendDiscount weekendDiscount,
                    PriceBeforeDiscount priceBeforeDiscount) {
        this.christmasDiscount = christmasDiscount;
        this.giftEvent = giftEvent;
        this.specialDiscount = specialDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
        this.priceBeforeDiscount = priceBeforeDiscount;

    }

    public int getTotalBenefit() {
        return christmasDiscount.getDiscountedValue() + giftEvent.getDiscountedValue()
                + specialDiscount.getDiscountedValue()
                + weekdayDiscount.getDiscountedValue() + weekendDiscount.getDiscountedValue();
    }

    public int getExpectedDiscount() {
        return christmasDiscount.getDiscountedValue() + specialDiscount.getDiscountedValue()
                + weekdayDiscount.getDiscountedValue() + weekendDiscount.getDiscountedValue();
    }

    public List<String> getEventHistory() {
        if (christmasDiscount.isEventActive() && priceBeforeDiscount.over10kWon()) {
            christmasDiscount.calculateDiscount();
            eventHistory.add(christmasDiscount.getEventLog());
        }
        if (specialDiscount.isEventActive() && priceBeforeDiscount.over10kWon()) {
            specialDiscount.calculateDiscount();
            eventHistory.add(specialDiscount.getEventLog());
        }
        if (weekdayDiscount.isEventActive() && priceBeforeDiscount.over10kWon()) {
            weekdayDiscount.calculateDiscount();
            if (weekdayDiscount.getDiscountedValue() > 0) {
                eventHistory.add(weekdayDiscount.getEventLog());
            }
        }
        if (weekendDiscount.isEventActive() && priceBeforeDiscount.over10kWon()) {
            weekendDiscount.calculateDiscount();
            if (weekendDiscount.getDiscountedValue() > 0) {
                eventHistory.add(weekendDiscount.getEventLog());
            }
        }
        if (giftEvent.isEventActive() && priceBeforeDiscount.over10kWon() && priceBeforeDiscount.over120kWon()) {
            giftEvent.calculateDiscount();
            eventHistory.add(giftEvent.getEventLog());
        }
        if (eventHistory.isEmpty()) {
            eventHistory.add(Constants.NOTHING);
        }
        return eventHistory;
    }
}
