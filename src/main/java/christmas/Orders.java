package christmas;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Orders {
    List<Order> OrderedItems;

    public Orders(List<Order> orderedItems) {
        this.OrderedItems = orderedItems;
        validate();
    }

    public List<Order> getOrderedItems() {
        return OrderedItems;
    }

    private void validate() {
        checkAllSize();
        checkDuplicateMenu();
        checkOnlyDrink();
    }

    private void checkAllSize() {
        int allCount = OrderedItems.stream()
                .mapToInt(Order::getCount)
                .sum();
        if (allCount > 20) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private void checkDuplicateMenu() {
        Set<String> compareMenu = OrderedItems.stream()
                .map(Order::getName)
                .collect(Collectors.toSet());

        if (compareMenu.size() != OrderedItems.size()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private void checkOnlyDrink() {
        List<String> compareMenu = OrderedItems.stream()
                .map(Order::getName)
                .filter(x -> Menu.getDrinkMenu().contains(x))
                .toList();

        if (compareMenu.size() == OrderedItems.size()) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

}
