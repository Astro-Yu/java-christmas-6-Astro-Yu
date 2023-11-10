package christmas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {

    final static String COMMA = ",";
    final static String DASH = "-";

    public static int stringToInteger(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> splitWithComma(String input) {
        return new ArrayList<>(Arrays.asList(input.split(COMMA)));
    }

    public static List<String> splitWithDash(String input) {
        return new ArrayList<>(Arrays.asList(input.split(DASH)));
    }

    public static boolean isDigit(String input) {
        for (int index = 0; index < input.length(); index++) {
            if (!Character.isDigit(input.charAt(index))) {
                return true;
            }
        }
        return false;
    }
}
