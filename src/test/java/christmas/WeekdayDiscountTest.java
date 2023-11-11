package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WeekdayDiscountTest {

    @ParameterizedTest
    @DisplayName("메뉴에 포함된 디저트의 숫자만큼 할인하는 테스트입니다.(한 메뉴일때)")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void desertOneTest(int target) {
        Order order1 = new Order("양송이수프", 1);
        Order order2 = new Order("아이스크림", target);
        Order order3 = new Order("티본스테이크", 6);

        Orders orders = new Orders(List.of(order1, order2, order3));

        WeekdayDiscount weekdayDiscount = new WeekdayDiscount(orders, new Day(11));

        int result = weekdayDiscount.getDiscountedValue();
        int answer = 2023 * target;

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("메뉴에 포함된 디저트의 숫자만큼 할인하는 테스트입니다.(여러 메뉴일때)")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void desertMultiTest(int target) {
        Order order1 = new Order("양송이수프", 1);
        Order order2 = new Order("아이스크림", target);
        Order order3 = new Order("초코케이크", 3);

        Orders orders = new Orders(List.of(order1, order2, order3));

        WeekdayDiscount weekdayDiscount = new WeekdayDiscount(orders, new Day(11));

        int result = weekdayDiscount.getDiscountedValue();
        int answer = 2023 * (target + 3);

        assertThat(result).isEqualTo(answer);
    }
}
