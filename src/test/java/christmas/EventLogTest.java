package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import christmas.Model.Day;
import christmas.Model.Discount.ChristmasDiscount;
import christmas.Model.Discount.GiftEvent;
import christmas.Model.Discount.SpecialDiscount;
import christmas.Model.Discount.WeekdayDiscount;
import christmas.Model.Discount.WeekendDiscount;
import christmas.Model.EventLog;
import christmas.Model.Order;
import christmas.Model.Orders;
import christmas.Model.PriceBeforeDiscount;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class EventLogTest {

    Order order1 = new Order("양송이수프", "5");
    Order order2 = new Order("아이스크림", "5");
    Order order3 = new Order("티본스테이크", "9");
    Orders orders = new Orders(List.of(order1, order2, order3));
    Day day = new Day(25);

    @Test
    @DisplayName("이벤트 로그를 정확히 출력하는지 확인합니다.")
    void EventLogTest() {
        ChristmasDiscount christmasDiscount = new ChristmasDiscount(day);
        GiftEvent giftEvent = new GiftEvent(orders, new Day(25));
        WeekdayDiscount weekdayDiscount = new WeekdayDiscount(orders, day);
        WeekendDiscount weekendDiscount = new WeekendDiscount(orders, day);
        SpecialDiscount specialDiscount = new SpecialDiscount(day);
        PriceBeforeDiscount priceBeforeDiscount = new PriceBeforeDiscount(orders);

        EventLog eventLog = new EventLog(christmasDiscount, giftEvent, specialDiscount, weekdayDiscount,
                weekendDiscount, priceBeforeDiscount);

        List<String> result = eventLog.getEventHistory();

        List<String> answer = new ArrayList<>(
                List.of("크리스마스 디데이 할인: -3500원", "특별 할인: -1000원", "평일 할인: -10115원", "증정 이벤트: -25000원"));

        assertThat(answer).isEqualTo(answer);
    }


}
