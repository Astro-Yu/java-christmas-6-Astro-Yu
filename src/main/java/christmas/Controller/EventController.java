package christmas.Controller;

import static christmas.Controller.UserInputHandler.getValidDate;
import static christmas.Controller.UserInputHandler.getValidMenu;

import christmas.Model.Day;
import christmas.Model.EventLog;
import christmas.Model.Orders.Orders;
import christmas.Model.PriceBeforeDiscount;
import christmas.Model.TotalBenefit;
import christmas.View.InputView;
import christmas.View.OutputView;

public class EventController {

    public void runEvent() {
        InputView.printStartMessage();
        Day day = getValidDate();
        Orders orders = getValidMenu();
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(orders);
        EventLog eventLog = new DiscountController(day, orders).setEventLog();

        printEventSummary(day, orders, priceBeforeDiscount, eventLog);
    }

    private void printEventSummary(Day day, Orders orders, PriceBeforeDiscount priceBeforeDiscount, EventLog eventLog) {

        OutputView.printBenefitPreview(day);
        OutputView.printOrderMenu(orders);
        OutputView.printOriginalPrice(priceBeforeDiscount);
        OutputView.printGiftEvent(priceBeforeDiscount);
        OutputView.printEventLog(eventLog);

        TotalBenefit totalBenefit = new TotalBenefit(eventLog.getTotalBenefit());
        OutputView.printAllBenefit(totalBenefit);
        OutputView.printAfterDiscount(orders, eventLog.getExpectedDiscount());
        OutputView.printEventBadge(totalBenefit);
    }
}
