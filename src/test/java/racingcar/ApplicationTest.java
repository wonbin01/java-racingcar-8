package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.validator.InputException;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 이름이_비어있으면_오류발생() {
        InputException inputException = new InputException();
        assertThatCode(() ->
                inputException.delimiter("")).isInstanceOf(IllegalArgumentException.class).hasMessage("입력이 비어있습니다.");
    }

    @Test
    void 중간에_이름이_비어있으면_오류발생() {
        InputException inputException = new InputException();
        assertThatCode(() ->
                inputException.delimiter("pobi,,jun")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 이름은 사용할 수 없습니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
