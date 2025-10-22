package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.entity.Car;
import racingcar.validator.InputException;

public class InputHandler {
    public List<String> cars;
    public List<Car> racingCars;
    InputException ex = new InputException();

    public void startInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = Arrays.asList(ex.delimiter(input));
        ex.checkUniqueInput(cars);
        ex.checkInputLength(cars);
        ex.checkEngAndNumber(cars);
    }
}
