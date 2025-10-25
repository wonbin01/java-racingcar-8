package racingcar.entity;

public class Car {
    private String carName;
    private Long distance;

    public Car(String carName) {
        this.carName = carName;
        this.distance = 0L;
    }

    public String getCarName() {
        return carName;
    }

    public Long getDistance() {
        return distance;
    }

    public void incrementDistance() {
        this.distance += 1L;
    }
}
