package christmas;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @Test
    @DisplayName("아무것도 입력하지 않았는지 확인합니다.")
    void checkEmptyTest() {
        String target = "";

        Assertions.assertThatThrownBy(() -> InputValidator.checkInputEmpty(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_EMPTY_MESSGAE.getMessage());
    }

    @Test
    @DisplayName("공백을 입력했는지 확인합니다.")
    void checkBlankTest() {
        String target = " ";

        Assertions.assertThatThrownBy(() -> InputValidator.checkInputBlank(target))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INPUT_BLANK_MESSAGE.getMessage());
    }

    @ParameterizedTest
    @DisplayName("숫자 이외를 입력했는지 확인합니다.")
    @ValueSource(strings = {",", "k", "아", "--"})
    void checkDigitTest(String input) {
        Assertions.assertThatThrownBy(() -> InputValidator.checkInputDigit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessages.INVALID_NUMBER_MESSAGE.getMessage());
    }

}
