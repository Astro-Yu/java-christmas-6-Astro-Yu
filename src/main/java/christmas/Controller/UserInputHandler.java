package christmas.Controller;

import christmas.View.InputView;
import java.util.List;

public class UserInputHandler {

    public static int getValidDate() {
        while (true) {
            try {
                return InputView.readDate();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<String> getValidMenu() {
        while (true) {
            try {
                return InputView.readOrders();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
