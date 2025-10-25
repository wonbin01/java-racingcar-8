package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

public class InputExceptionTest {
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

    @Test
    void 입력에_중복된_이름이_있으면_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() ->
                inputException.checkUniqueInput(List.of("pobi", "pobi", "jun")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름이 존재합니다.");
    }

    @Test
    void 이름의_길이가_5를_초과한다면_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() ->
                inputException.checkInputLength(List.of("wonbin", "pobi"))).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    void 입력은_영어와_숫자만_아니면_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() ->
                inputException.checkEngAndNumber(List.of("원빈", "pobi", "jun"))).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessage("이름은 영어와 숫자로만 구성되어야합니다.");
    }

    @Test
    void validateInput_통합_테스트() {
        InputException inputException = new InputException();
        assertThatCode(() ->
                inputException.validateInput(List.of("pobi", "1pobi", "jun12"))).doesNotThrowAnyException();
    }

    @Test
    void 숫자입력시_빈칸이_주어진_경우_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() -> inputException.validateNumbers("")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수를 입력해야 합니다.");
    }

    @Test
    void 숫자입력시_1미만의_수가_입력된_경우_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() -> inputException.validateNumbers("-3")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1 이상이어야 합니다.");
    }

    @Test
    void 숫자입력시_숫자가아니라_다른_문자가_입력된_경우_오류발생() {
        InputException inputException = new InputException();
        assertThatThrownBy(() -> inputException.validateNumbers("삼십")).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해야 합니다.");
    }
}
