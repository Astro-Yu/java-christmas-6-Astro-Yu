package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChristmasDiscountTest {

    @Test
    @DisplayName("크리스마스 할인을 확인합니다.")
    void specialDiscountTest() {

        ChristmasDiscount christmasDiscount = new ChristmasDiscount(new Day(24));

        int result = christmasDiscount.getDiscountedValue();
        int answer = 1000 + 100 * 24;

        assertThat(result).isEqualTo(answer);
    }
}
