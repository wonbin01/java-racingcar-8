package racingcar.handler;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.entity.Car;
import racingcar.entity.Racing;
import racingcar.validator.InputException;

public class InputHandler {
    public List<String> cars;
    public List<Car> carList = new ArrayList<>();
    InputException ex = new InputException();
    Racing race;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        cars = Arrays.asList(ex.delimiter(input));
        ex.validateInput(cars);
        System.out.println("시도할 횟수는 몇 회인가요?");
        input = Console.readLine();
        Long distance = ex.validateNumbers(input);
        createCarList();
        race = new Racing(carList, distance);
        race.startRace();
    }

    private void createCarList() {
        for (String car : cars) {
            Car carObj = new Car(car);
            carList.add(carObj);
        }
    }


}
