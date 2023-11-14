package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Day;
import christmas.Model.Discount.ChristmasDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ChristmasDiscountTest {

    @Test
    @DisplayName("크리스마스 할인을 확인합니다.")
    void christmasDiscountTest() {

        ChristmasDiscount christmasDiscount = new ChristmasDiscount(new Day(24));
        christmasDiscount.calculateDiscount();
        int result = christmasDiscount.getDiscountedValue();
        int answer = 1000 + 100 * 23;

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("크리스마스 할인을 기간을 확인합니다.")
    @ValueSource(ints = {26, 27, 31})
    void isChristmasDiscountActive(int target) {

        ChristmasDiscount christmasDiscount = new ChristmasDiscount(new Day(target));
        christmasDiscount.calculateDiscount();

        boolean result = christmasDiscount.isEventActive();
        boolean answer = false;

        assertThat(result).isEqualTo(answer);
    }


}
