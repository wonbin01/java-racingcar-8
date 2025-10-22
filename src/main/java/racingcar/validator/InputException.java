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
}
