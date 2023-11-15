package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MyApplicationTest extends NsTest {
    @Test
    void 할인_테스트1() { // 크리스마스 디데이 할인, 특별할인, 평일 할인, 증정이벤트가 포함되었는지 확인합니다.
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "평일 할인: ",
                    "크리스마스 디데이 할인: ",
                    "특별 할인: ",
                    "증정 이벤트: "
            );
        });
    }

    @Test
    void 할인_테스트2() { // 주말 할인, 증정이벤트가 포함되었는지 확인합니다.
        assertSimpleTest(() -> {
            run("29", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                    "주말 할인: ",
                    "증정 이벤트: "
            );
        });
    }

    @Test
    void 뱃지_테스트() {
        assertSimpleTest(() -> {
            run("29", "해산물파스타-5,");
            assertThat(output()).contains(
                    "산타"
            );
        });
    }

    @Test
    void 초과_수량_주문_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-10,바비큐립-11");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_안함_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-0,바비큐립-11");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }


    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_중복_테스트() {
        assertSimpleTest(() -> {
            runException("3", "티본스테이크-1,티본스테이크-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"김치볶음밥-2", "코카콜라-2", "알리오올리오-2", "백반정식-1"})
    void 없는_주문_테스트(String target) {
        assertSimpleTest(() -> {
            runException("3", target, "제로콜라-1");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"아이스크림", "아이스크림한개", "아이스크림-", "아이스크림1"})
    void 주문_형식_테스트(String target) {
        assertSimpleTest(() -> {
            runException("3", target);
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
