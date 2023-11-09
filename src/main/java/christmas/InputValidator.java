package christmas;

public class InputValidator {
    public static void checkInputEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessages.INPUT_EMPTY_MESSGAE.getMessage());
        }
    }

    public static void checkInputBlank(String input) {
        if (isBlank(input)){
            throw new IllegalArgumentException(ErrorMessages.INPUT_BLANK_MESSAGE.getMessage());
        }
    }

    private static boolean isBlank (String input){
        return input.isBlank();
    }

    private static boolean isEmpty (String input){
        return input.isEmpty();
    }
}

