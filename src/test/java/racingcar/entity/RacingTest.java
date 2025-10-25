package racingcar.entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void 거리만큼_하이폰_표시() {
        Racing racing = new Racing(List.of("pobi"), 1);
        String result = racing.createDistance(2L);
        assertThat(result).isEqualTo("--");
    }
}
