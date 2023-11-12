package christmas.Model;

import christmas.Constants.Constants;
import christmas.Model.Discount.ChristmasDiscount;
import christmas.Model.Discount.GiftEvent;
import christmas.Model.Discount.SpecialDiscount;
import christmas.Model.Discount.WeekdayDiscount;
import christmas.Model.Discount.WeekendDiscount;
import java.util.List;

public class EventLog {
    ChristmasDiscount christmasDiscount;
    GiftEvent giftEvent;
    SpecialDiscount specialDiscount;
    WeekdayDiscount weekdayDiscount;
    WeekendDiscount weekendDiscount;

    List<String> eventHistory;

    public EventLog(ChristmasDiscount christmasDiscount, GiftEvent giftEvent, SpecialDiscount specialDiscount,
                    WeekdayDiscount weekdayDiscount, WeekendDiscount weekendDiscount) {
        this.christmasDiscount = christmasDiscount;
        this.giftEvent = giftEvent;
        this.specialDiscount = specialDiscount;
        this.weekdayDiscount = weekdayDiscount;
        this.weekendDiscount = weekendDiscount;
    }

    public List<String> getEventHistory() {
        if (christmasDiscount.isEventActive()) {
            eventHistory.add(christmasDiscount.getEventLog());
        }
        if (specialDiscount.isEventActive()) {
            eventHistory.add(specialDiscount.getEventLog());
        }
        if (weekdayDiscount.isEventActive()) {
            eventHistory.add(weekdayDiscount.getEventLog());
        }
        if (weekendDiscount.isEventActive()) {
            eventHistory.add(weekendDiscount.getEventLog());
        }
        if (giftEvent.isEventActive()) {
            eventHistory.add(giftEvent.getEventLog());
        }
        if (eventHistory.isEmpty()) {
            eventHistory.add(Constants.NOTHING);
        }
        return eventHistory;
    }
}
