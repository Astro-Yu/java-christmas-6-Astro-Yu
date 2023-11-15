package christmas.Model.Orders;

import christmas.Constants.Menu;
import christmas.Constants.Messages.ErrorMessages;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {
    private final List<Order> orderedItems;

    public Orders(List<Order> inputOrderedItems) {
        this.orderedItems = inputOrderedItems;
        validate();
    }

    public List<Order> getOrderedItems() {
        return orderedItems;
    }

    public int getTotalPrice() {
        return orderedItems.stream().mapToInt(Order::getPrice).sum();
    }

    private void validate() {
        checkAllSize();
        checkDuplicateMenu();
        checkOnlyDrink();
    }

    private void checkAllSize() {
        int allCount = orderedItems.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (allCount > 20) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private void checkDuplicateMenu() {
        Set<String> compareMenu = orderedItems.stream()
                .map(Order::getName)
                .collect(Collectors.toSet());

        if (compareMenu.size() != orderedItems.size()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private void checkOnlyDrink() {
        List<String> compareMenu = orderedItems.stream()
                .map(Order::getName)
                .filter(x -> Menu.getDrinkMenu().contains(x))
                .toList();

        if (compareMenu.size() == orderedItems.size()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

}
