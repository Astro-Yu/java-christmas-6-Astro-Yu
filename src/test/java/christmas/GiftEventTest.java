package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Day;
import christmas.Model.Discount.GiftEvent;
import christmas.Model.Order;
import christmas.Model.Orders;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftEventTest {

    @Test
    @DisplayName("샴페인 증정 값을 확인합니다.")
    void GiftEventTest() {

        Order order1 = new Order("양송이수프", "1");
        Order order2 = new Order("아이스크림", "5");
        Order order3 = new Order("티본스테이크", "6");

        GiftEvent giftEvent = new GiftEvent(new Orders(List.of(order1, order2, order3)), new Day(11));
        giftEvent.calculateDiscount();

        int result = giftEvent.getDiscountedValue();
        int answer = 25_000;

        assertThat(result).isEqualTo(answer);
    }
}
