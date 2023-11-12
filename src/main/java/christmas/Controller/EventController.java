package christmas.Controller;

import static christmas.Controller.UserInputHandler.getValidDate;
import static christmas.Controller.UserInputHandler.getValidMenu;

import christmas.Model.Day;
import christmas.Model.EventLog;
import christmas.Model.Orders;
import christmas.Model.PriceBeforeDiscount;
import christmas.Model.TotalBenefit;
import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;

public class EventController {

    public void runEvent() {
        InputView.printStartMessage();
        int date = getValidDate();
        List<String> userOrders = getValidMenu();

        OrderController orderController = new OrderController(date, userOrders);
        Day day = orderController.getDay();
        Orders orders = orderController.getOrders();

        OutputView.printBenefitPreview(day);
        OutputView.printOrderMenu(orders);
        OutputView.printOriginalPrice(new PriceBeforeDiscount(orders));

        OutputView.printGiftEvent(new PriceBeforeDiscount(orders));

        EventLog eventLog = new DiscountController(day, orders).setEventLog();

        OutputView.printEventLog(eventLog);

        OutputView.printAllBenefit(new TotalBenefit(eventLog.getTotalBenefit()));
        OutputView.printAfterDiscount(orders, eventLog.getTotalBenefit());

        OutputView.printEventBadge(new TotalBenefit(eventLog.getTotalBenefit()));
    }
}
