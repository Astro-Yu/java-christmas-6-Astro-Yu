package christmas.Utils;

import static christmas.Utils.Utils.numberFormat;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UtilsTest {
    @Test
    @DisplayName("String을 Integer로 변환하는 테스트 입니다.")
    void stringToIntegerTest() {
        String target = "3";
        int result = Utils.stringToInteger(target);
        int answer = 3;

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("String을 ,(comma)로 구분하는 테스트 입니다.")
    void splitWithCommaTest() {
        String target = "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1";

        List<String> result = Utils.splitWithComma(target);
        List<String> answer = new ArrayList<>(List.of("티본스테이크-1", "바비큐립-1", "초코케이크-2", "제로콜라-1"));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("String을 -(dash)로 구분하는 테스트 입니다.")
    void splitWithDashTest() {
        String target = "티본스테이크-1";

        List<String> result = Utils.splitWithDash(target);
        List<String> answer = new ArrayList<>(List.of("티본스테이크", "1"));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("입력받은 정수를 천의자리마다 구분자 ,를 넣어주는 테스트입니다.")
    void numberFormatTest() {
        int input = 1_000_000;

        String answer = "1,000,000";

        assertThat(numberFormat(input)).isEqualTo(answer);
    }
}
