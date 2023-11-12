package christmas.Controller;

import christmas.Model.Day;
import christmas.Model.Order;
import christmas.Model.Orders;
import christmas.Utils;
import java.util.List;
import java.util.stream.Collectors;

public class OrderController {
    final static int MENU_INDEX = 0;
    final static int COUNT_INDEX = 1;

    final int inputDate;
    final List<String> inputOrders;

    public OrderController(int inputDate, List<String> inputOrders) {
        this.inputDate = inputDate;
        this.inputOrders = inputOrders;
    }

    public Day getDay() {
        return new Day(this.inputDate);
    }

    public Orders getOrders() {
        return new Orders(
                inputOrders.stream()
                        .map(Utils::splitWithDash)
                        .map(orderMenu -> new Order(orderMenu.get(MENU_INDEX),
                                Integer.parseInt(orderMenu.get(COUNT_INDEX))))
                        .collect(Collectors.toList())
        );
    }

}
