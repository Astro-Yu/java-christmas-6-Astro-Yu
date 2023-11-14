package christmas.Controller;

import christmas.Model.Day;
import christmas.Model.Orders.Order;
import christmas.Model.Orders.Orders;
import christmas.Utils.Utils;
import christmas.View.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputHandler {

    public static Day getValidDate() {
        while (true) {
            try {
                int date = InputView.readDate();
                return new Day(date);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Orders getValidMenu() {
        while (true) {
            try {
                List<String> inputOrderMenus = InputView.readOrders();
                List<Order> orderMenus = inputOrderMenus.stream()
                        .map(Utils::splitWithDash)
                        .map(orderMenu -> new Order(orderMenu.get(0), orderMenu.get(1)))
                        .collect(Collectors.toList());

                return new Orders(orderMenus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
