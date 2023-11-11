package christmas;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TotalBenefitTest {

    @Test
    @DisplayName("정확한 뱃지를 반환하는지 확인하는 테스트입니다.")
    void getBadgeTest() {
        String[] badges = {"없음", "별", "트리", "산타"};
        int[] benefit = {1000, 5000, 10000, 20000};

        for (int index = 0; index < badges.length; index++) {
            TotalBenefit totalBenefit = new TotalBenefit(benefit[index]);
            assertThat(totalBenefit.getBadge()).isEqualTo(badges[index]);
        }
    }
}
