package christmas.Model;

import static christmas.Model.TotalOrderIncome.calculateTotalIncome;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalOrderIncomeTest {

    @Test
    @DisplayName("12월 총 구매금액을 계산하는 테스트입니다.")
    void calculateTotalIncomeTest() {
        List<Integer> incomes = List.of(12_000, 50_000, 60_000, 100_000);

        for (Integer income : incomes) {
            calculateTotalIncome(income);
        }

        int result = incomes.stream().mapToInt(Integer::intValue).sum();

        assertThat(TotalOrderIncome.getTotalIncome()).isEqualTo(result);
    }
}
