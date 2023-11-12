package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Discount.PriceBeforeDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class PriceBeforeDiscountTest {

    @ParameterizedTest
    @DisplayName("총 주문 금액이 12만원을 넘었는지 확인합니다.")
    @ValueSource(ints = {120_000, 120_001, 130_000})
    void over120kWonTest(int target) {
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(target);

        String result = priceBeforeDiscount.getGiftMenu();
        String answer = "샴페인 1개";

        assertThat(result).isEqualTo(answer);


    }

    @ParameterizedTest
    @DisplayName("총 주문 금액이 만원을 넘었는지 확인합니다.")
    @ValueSource(ints = {10_000, 10_001, 30_000})
    void over10kWonTest(int target) {
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(target);

        boolean result = priceBeforeDiscount.over10kWon();
        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }
}
