package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpecialDiscountTest {
    @Test
    @DisplayName("스페셜 할인을 확인합니다.")
    void specialDiscountTest() {

        SpecialDiscount specialDiscount = new SpecialDiscount(new Day(11));

        int result = specialDiscount.getDiscountedValue();
        int answer = 1000;

        assertThat(result).isEqualTo(answer);
    }
}
