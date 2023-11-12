package christmas.Constants;

public enum ErrorMessages {

    ERROR_PREFIX("[ERROR] "),
    INPUT_BLANK_MESSAGE("입력은 공백일 수 없습니다."),
    INPUT_EMPTY_MESSGAE("값을 입력하지 않았습니다."),
    INVALID_NUMBER_MESSAGE("반드시 숫자로만 입력해야 합니다."),
    INVALID_DATE_RANGE("유효하지 않은 날짜입니다. 다시 입력해 주세요"),
    INPUT_INVALID_ORDER("유효하지 않은 주문입니다. 다시 입력해 주세요");


    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }

}
