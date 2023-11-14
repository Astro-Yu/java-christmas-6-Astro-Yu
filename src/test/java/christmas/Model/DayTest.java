package christmas.Model;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Constants.ErrorMessages;
import christmas.Model.Day;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class DayTest {


    @ParameterizedTest
    @DisplayName("적절한 날짜가 입력됐는지 확인합니다.")
    @ValueSource(ints = {0, 32, -1, 100})
    void isProperDate(int target) {

        Assertions.assertThatThrownBy(() -> new Day(target)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_DATE_RANGE.getMessage());

    }

    @ParameterizedTest
    @DisplayName("해당 요일이 주중인지 체크하는 테스트입니다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 10, 11, 12, 13, 14, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 31})
    void isWeekdayTest(int target) {
        Day day = new Day(target);
        boolean result = day.isWeekend();

        boolean answer = false;

        assertThat(result).isEqualTo(answer);
    }

    @ParameterizedTest
    @DisplayName("해당 요일이 주말인지 체크하는 테스트입니다.")
    @ValueSource(ints = {1, 2, 8, 9, 15, 16, 22, 23, 29, 30})
    void isWeekendTest(int target) {
        Day day = new Day(target);
        boolean result = day.isWeekend();

        boolean answer = true;

        assertThat(result).isEqualTo(answer);
    }
}
