package christmas.View.Validator;

import static christmas.Utils.Utils.isDigit;

import christmas.Constants.Messages.ErrorMessages;
import java.util.regex.Pattern;

public class InputValidator {
    public static void checkInputEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY_MESSGAE.getMessage());
        }
    }

    public static void checkInputBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_BLANK_MESSAGE.getMessage());
        }
    }

    public static void checkInputDigit(String input) {
        if (isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_DATE_RANGE.getMessage());
        }
    }

    public static void checkInputFormat(String input) {
        if (!isValidOrderFormat(input)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_INVALID_ORDER.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    public static boolean isValidOrderFormat(String input) {
        String regex = "[가-힣]+-[0-9]+";
        return Pattern.matches(regex, input);
    }
}

