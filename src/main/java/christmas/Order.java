package christmas;

import java.util.List;


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

    private void validate() {
        checkInvalidCount();
        checkOrderInMenu();
    }

    private void checkOrderInMenu() {
        List<String> menuNames = christmas.Menu.getMenuNamesAsList();
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
