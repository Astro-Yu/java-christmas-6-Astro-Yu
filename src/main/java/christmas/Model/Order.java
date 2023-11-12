package christmas.Model;

import christmas.Constants.ErrorMessages;
import christmas.Constants.Menu;
import java.util.List;
import java.util.Map;


public class Order {
    private final static int MIN_ORDER_SIZE = 0;
    private final static int MAX_ORDER_SIZE = 20;

    final String name;
    final int count;

    public Order(String name, int count) {
        this.name = name;
        this.count = count;
        validate();
    }

    public String getName() {
        return this.name;
    }

    public int getCount() {
        return this.count;
    }

    public int getPrice() {
        Map<String, Integer> menuAndPrice = Menu.getMenuNamesAndPrices();
        return menuAndPrice.get(name) * count;
    }

    private void validate() {
        checkInvalidCount();
        checkOrderInMenu();
    }

    private void checkOrderInMenu() {
        List<String> menuNames = Menu.getMenuNames();
        if (!menuNames.contains(name)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private void checkInvalidCount() {
        if (count <= MIN_ORDER_SIZE || count > MAX_ORDER_SIZE) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }
}
