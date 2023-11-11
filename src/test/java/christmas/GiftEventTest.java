package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftEventTest {

    @Test
    @DisplayName("샴페인 증정 값을 확인합니다.")
    void GiftEventTest() {

        GiftEvent giftEvent = new GiftEvent(new Day(11));

        int result = giftEvent.getDiscountedValue();
        int answer = 25_000;

        assertThat(result).isEqualTo(answer);
    }
}
