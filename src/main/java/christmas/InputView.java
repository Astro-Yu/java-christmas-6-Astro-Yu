package christmas;

import static christmas.Utils.stringToInteger;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public int readDate() {
        System.out.println(InputMessages.ENTER_ORDER_PROMPT);
        String input = Console.readLine();

        return stringToInteger(input);
    }

}
