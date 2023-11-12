package christmas.View;

import static christmas.InputValidator.checkInputBlank;
import static christmas.InputValidator.checkInputDigit;
import static christmas.InputValidator.checkInputEmpty;
import static christmas.Utils.splitWithComma;
import static christmas.Utils.stringToInteger;

import camp.nextstep.edu.missionutils.Console;
import christmas.Constants.InputMessages;
import java.util.List;

public class InputView {

    public static void printStartMessage() {
        System.out.println(InputMessages.START_MESSAGE);
    }

    public int readDate() {
        System.out.println(InputMessages.ENTER_VISIT_DATE);
        String input = Console.readLine();
        validateInputDate(input);

        return stringToInteger(input);
    }

    public List<String> readOrders() {
        System.out.println(InputMessages.ENTER_ORDER_PROMPT);
        String input = Console.readLine();
        validateInputOrders(input);

        return splitWithComma(input);
    }

    private void validateInputOrders(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
    }

    private void validateInputDate(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }
}
