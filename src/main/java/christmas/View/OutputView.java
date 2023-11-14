package christmas.View;

import static christmas.Utils.Utils.numberFormat;

import christmas.Constants.Constants;
import christmas.Constants.OutputMessages;
import christmas.Model.Day;
import christmas.Model.EventLog;
import christmas.Model.Orders.Order;
import christmas.Model.Orders.Orders;
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
        System.out.println(numberFormat(priceBeforeDiscount.getPrice()) + Constants.WON);
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
        if (totalBenefit.getPrice() > 0) { // 할인금액이 0원 초과인 경우에만 - 를 붙여서 출력시킴
            System.out.println(Constants.MINUS + numberFormat(totalBenefit.getPrice()) + Constants.WON);
        }
        if (totalBenefit.getPrice() == 0) { // 할인금액이 0원인 경우 - 없이 출력시킴.
            System.out.println(totalBenefit.getPrice() + Constants.WON);
        }
        System.out.println();
    }

    public static void printAfterDiscount(Orders orders, int discount) {
        System.out.println(OutputMessages.TOTAL_ORDER_AFTER_DISCOUNT);
        System.out.println(numberFormat(orders.getTotalPrice() - discount) + Constants.WON);
        System.out.println();
    }

    public static void printEventBadge(TotalBenefit totalBenefit) {
        System.out.println(OutputMessages.DEC_EVENT_BADGE);
        System.out.println(totalBenefit.getBadge());
    }
}
