package racingcar.entity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void 거리만큼_하이폰_표시() {
        Racing racing = new Racing(List.of(new Car("pobi")), 1);
        String result = racing.createDistance(2L);
        assertThat(result).isEqualTo("--");
    }

    @Test
    void 최대_거리_운전자가_우승자로_출력() {
        // given
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.incrementDistance();
        pobi.incrementDistance();
        Racing racing = new Racing(List.of(pobi, woni), 1);
        String result = racing.printWinner();
        assertThat(result).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    void 최대_거리_확인_테스트() {
        Car pobi = new Car("pobi");
        Car woni = new Car("woni");
        pobi.incrementDistance();
        pobi.incrementDistance();
        Racing racing = new Racing(List.of(pobi, woni), 1);
        racing.printWinner();
        assertThat(racing.getMaxDistance()).isEqualTo(2L);
    }
}
