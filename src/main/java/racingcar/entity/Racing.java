package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int chance;
    private List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

    public Racing(List<String> carname, int number) {
        cars = new ArrayList<>();
        for (String name : carname) {
            cars.add(new Car(name));
        }
        this.chance = number;
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < chance; i++) {
            raceOnce();
        }
    }

    public void raceOnce() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInList(numbers);
            if (randomNumber >= 4) {
                car.incrementDistance();
            }
        }
    }

    public void printStatus() {
        for (Car car : cars) {
            Long distance = car.getDistance();
            String name = car.getCarName();
            String mark = createDistance(distance);
            System.out.println(name + " : " + mark);
        }
        System.out.println("");
    }

    public String createDistance(Long number) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < number; i++) {
            distance.append("-");
        }
        return distance.toString();
    }

}
