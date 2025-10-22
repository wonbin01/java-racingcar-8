package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    public String[] delimiter(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        return input.split(",");
    }

    public void checkUniqueInput(List<String> cars) {
        Set<String> uniqueCars = new HashSet<>(cars);
        if (uniqueCars.size() != cars.size()) {
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }

    public void checkInputLength(List<String> cars) {
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
            }
        }
    }

    public void checkEngAndNumber(List<String> cars) {
        for (String car : cars) {
            if (!car.matches("[a-zA-Z0-9]+")) {
                throw new IllegalArgumentException("이릉은 영어와 숫자로만 구성되어야합니다.");
            }
        }
    }
}
