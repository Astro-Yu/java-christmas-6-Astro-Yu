package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Orders.Order;
import christmas.Model.Orders.Orders;
import christmas.Model.PriceBeforeDiscount;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class PriceBeforeDiscountTest {

    Order order1 = new Order("양송이수프", "1");
    Order order2 = new Order("아이스크림", "5");
    Order order3 = new Order("티본스테이크", "6");

    Orders orders1 = new Orders(List.of(order1, order2, order3));

    @Test
    @DisplayName("총 주문 금액이 12만원을 넘었는지 확인합니다.")
    void over120kWonTest() {
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(orders1);

        String result = priceBeforeDiscount.getGiftMenu();
        String answer = "샴페인 1개";

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("총 주문 금액이 만원을 넘었는지 확인합니다.")
    void over10kWonTest() {
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(orders1);

        boolean result = priceBeforeDiscount.over10kWon();
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }
}
