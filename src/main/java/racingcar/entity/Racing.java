package racingcar.entity;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private final List<Car> cars;
    private final long chance;
    private Long maxDistance = Long.MIN_VALUE;

    public Racing(List<Car> carList, long number) {
        cars = carList;
        this.chance = number;
    }

    public void startRace() {
        System.out.println("실행 결과");
        for (int i = 0; i < chance; i++) {
            raceOnce();
        }
        printWinner();
    }

    public void raceOnce() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                car.incrementDistance();
            }
        }
        printStatus();
    }

    public void printStatus() {
        for (Car car : cars) {
            Long distance = car.getDistance();
            String name = car.getCarName();
            String mark = createDistance(distance);
            System.out.println(name + " : " + mark);
        }
        System.out.println(" ");
    }

    public String createDistance(Long number) {
        StringBuilder distance = new StringBuilder();
        for (int i = 0; i < number; i++) {
            distance.append("-");
        }
        return distance.toString();
    }

    public String printWinner() {
        findMaxDistance();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getCarName());
            }
        }
        String result = "최종 우승자 : " + String.join(", ", winners);
        System.out.println(result);
        return result;
    }

    private void findMaxDistance() {
        for (Car car : cars) {
            maxDistance = Long.max(maxDistance, car.getDistance());
        }
    }

}
