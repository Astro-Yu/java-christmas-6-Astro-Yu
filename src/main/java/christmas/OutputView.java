package christmas;

import java.util.List;

public class OutputView {

    public static void printBenefitPreview(Day day) {
        String resultMessage = String.format(OutputMessages.BENEFIT_PREVIEW_MESSAGE, day.getDate());
        System.out.println(resultMessage);
    }

    public static void printOrderMenu(Orders orders) {
        System.out.println(OutputMessages.ORDER_MENU);
        List<Order> orderItems = orders.getOrderedItems();

        orderItems.stream()
                .map(order -> String.format("%s %d개", order.getName(), order.getCount()))
                .forEach(System.out::println);
    }

    public static void printOriginalPrice(PriceBeforeDiscount priceBeforeDiscount) {
        System.out.println(OutputMessages.TOTAL_ORDER_BEFORE_DISCOUNT);
        System.out.println(priceBeforeDiscount.getPrice());
    }

    public static void printGiftEvent(PriceBeforeDiscount priceBeforeDiscount) {
        System.out.println(OutputMessages.GIFT_MENU);
        System.out.println(priceBeforeDiscount.getGiftMenu());
    }

    public static void printEventLog() {
        System.out.println(OutputMessages.EVENT_LOG);
    }

    public static void printAllBenefit(TotalBenefit totalBenefit) {
        System.out.println(OutputMessages.TOTAL_DISCOUNT);
        System.out.println(String.format(Constants.MINUS + totalBenefit.getPrice()));
    }

    public static void printAfterDiscount() {
        System.out.println(OutputMessages.TOTAL_ORDER_AFTER_DISCOUNT);
    }

    public static void printEventBadge(TotalBenefit totalBenefit) {
        System.out.println(OutputMessages.DEC_EVENT_BADGE);
        System.out.println(totalBenefit.getBadge());
    }
}
