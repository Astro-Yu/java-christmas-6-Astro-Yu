package christmas.View;

import christmas.Constants.Constants;
import christmas.Constants.OutputMessages;
import christmas.Model.Day;
import christmas.Model.EventLog;
import christmas.Model.Order;
import christmas.Model.Orders;
import christmas.Model.PriceBeforeDiscount;
import christmas.Model.TotalBenefit;
import java.util.List;

public class OutputView {

    public static void printBenefitPreview(Day day) {
        String resultMessage = String.format(OutputMessages.BENEFIT_PREVIEW_MESSAGE, day.getDate());
        System.out.println(resultMessage);
        System.out.println();
    }

    public static void printOrderMenu(Orders orders) {
        System.out.println(OutputMessages.ORDER_MENU);
        List<Order> orderItems = orders.getOrderedItems();

        orderItems.stream()
                .map(order -> String.format("%s %d" + Constants.COUNT, order.getName(), order.getCount()))
                .forEach(System.out::println);
        System.out.println();
    }

    public static void printOriginalPrice(PriceBeforeDiscount priceBeforeDiscount) {
        System.out.println(OutputMessages.TOTAL_ORDER_BEFORE_DISCOUNT);
        System.out.printf(priceBeforeDiscount.getPrice() + Constants.WON + "%n");
        System.out.println();
    }

    public static void printGiftEvent(PriceBeforeDiscount priceBeforeDiscount) {
        System.out.println(OutputMessages.GIFT_MENU);
        System.out.println(priceBeforeDiscount.getGiftMenu());
        System.out.println();
    }

    public static void printEventLog(EventLog eventLog) {
        System.out.println(OutputMessages.EVENT_LOG);
        List<String> eventHistory = eventLog.getEventHistory();

        eventHistory.forEach(System.out::println);
        System.out.println();
    }

    public static void printAllBenefit(TotalBenefit totalBenefit) {
        System.out.println(OutputMessages.TOTAL_DISCOUNT);
        System.out.println(Constants.MINUS + totalBenefit.getPrice() + Constants.WON);
        System.out.println();
    }

    public static void printAfterDiscount(Orders orders, int benefit) {
        System.out.println(OutputMessages.TOTAL_ORDER_AFTER_DISCOUNT);
        System.out.println(orders.getTotalPrice() - benefit + Constants.WON);
        System.out.println();
    }

    public static void printEventBadge(TotalBenefit totalBenefit) {
        System.out.println(OutputMessages.DEC_EVENT_BADGE);
        System.out.println(totalBenefit.getBadge());
    }
}
