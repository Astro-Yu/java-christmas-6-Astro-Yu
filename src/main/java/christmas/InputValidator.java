package christmas;

import static christmas.Utils.isDigit;

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
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_MESSAGE.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

}

