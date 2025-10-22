package racingcar.entity;

public class Car {
    private String carName;
    private Long distance;

    public Car(String carName) {
        this.carName = carName;
        this.distance = 0L;
    }
}
