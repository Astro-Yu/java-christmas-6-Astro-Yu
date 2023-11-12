package christmas;

import christmas.Constants.ErrorMessages;
import christmas.Model.Order;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTest {

    @ParameterizedTest
    @DisplayName("정확한 음식 이름이 할당됐는지 확인합니다.")
    @ValueSource(strings = {"설탕콜라", "타피스", "비본스테이크", "스크림아이"})
    void orderMenuNameTest(String target) {

        Assertions.assertThatThrownBy(() -> new Order(target, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
    }

    @ParameterizedTest
    @DisplayName("음식의 갯수가 유효한 범위인지 확인합니다.")
    @ValueSource(ints = {0, 21})
    void orderMenuNameTest(int target) {

        Assertions.assertThatThrownBy(() -> new Order("타파스", target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
    }
}
