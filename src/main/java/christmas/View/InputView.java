package christmas.View;

import static christmas.InputValidator.checkInputBlank;
import static christmas.InputValidator.checkInputDigit;
import static christmas.InputValidator.checkInputEmpty;
import static christmas.InputValidator.checkInputFormat;
import static christmas.Utils.splitWithComma;
import static christmas.Utils.stringToInteger;

import camp.nextstep.edu.missionutils.Console;
import christmas.Constants.InputMessages;
import java.util.List;

public class InputView {

    public static void printStartMessage() {
        System.out.println(InputMessages.START_MESSAGE);
    }

    public static int readDate() {
        System.out.println(InputMessages.ENTER_VISIT_DATE);
        String input = Console.readLine();
        validateInputDate(input);

        return stringToInteger(input);
    }

    public static List<String> readOrders() {
        System.out.println(InputMessages.ENTER_ORDER_PROMPT);
        String input = Console.readLine();
        validateInputOrders(input);

        List<String> orders = splitWithComma(input);

        for (String order : orders) {
            checkInputFormat(order);
        }

        return orders;
    }

    private static void validateInputOrders(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputFormat(input);
    }

    private static void validateInputDate(String input) {
        checkInputEmpty(input);
        checkInputBlank(input);
        checkInputDigit(input);
    }
}
