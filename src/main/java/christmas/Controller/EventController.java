package christmas.Controller;

import christmas.View.InputView;
import christmas.View.OutputView;
import java.util.List;

public class EventController {

    public void runEvent() {
        InputView.printStartMessage();
        int date = InputView.readDate();
        List<String> userOrders = InputView.readOrders();

        OutputView.printBenefitPreview();
    }


}
