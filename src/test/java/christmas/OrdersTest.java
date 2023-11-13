package christmas;

import christmas.Constants.ErrorMessages;
import christmas.Model.Order;
import christmas.Model.Orders;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrdersTest {

    @Test
    @DisplayName("중복된 메뉴가 있는지 확인합니다.")
    void duplicatedMenuTest() {
        Order order1 = new Order("양송이수프", "1");
        Order order2 = new Order("양송이수프", "1");
        Order order3 = new Order("티본스테이크", "1");

        Assertions.assertThatThrownBy(() -> new Orders(List.of(order1, order2, order3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
    }

    @Test
    @DisplayName("메뉴를 20개 초과하여 주문했는지 확인합니다.")
    void allSizeTest() {
        Order order1 = new Order("양송이수프", "10");
        Order order2 = new Order("아이스크림", "5");
        Order order3 = new Order("티본스테이크", "6");

        Assertions.assertThatThrownBy(() -> new Orders(List.of(order1, order2, order3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
    }

    @Test
    @DisplayName("음료만 주문했는지 확인합니다.")
    void onlyDrinkTest() {
        Order order1 = new Order("제로콜라", "1");
        Order order2 = new Order("샴페인", "1");
        Order order3 = new Order("레드와인", "1");

        Assertions.assertThatThrownBy(() -> new Orders(List.of(order1, order2, order3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
    }
}
