package christmas;

import static christmas.Utils.splitWithComma;
import static christmas.Utils.stringToInteger;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public int readDate() {
        System.out.println(InputMessages.ENTER_VISIT_DATE);
        String input = Console.readLine();

        return stringToInteger(input);
    }

    public List<String> readOrders(){
        System.out.println(InputMessages.ENTER_ORDER_PROMPT);
        String input = Console.readLine();

        return splitWithComma(input);
    }
}
