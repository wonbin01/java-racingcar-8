package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    public List<String> racingCars;

    public void startInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        racingCars = Arrays.asList(delimiter(input));
    }

    public String[] delimiter(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        return input.split(",");
    }
}
