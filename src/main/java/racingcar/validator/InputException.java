package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputException {
    public String[] delimiter(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        String[] names = input.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].trim().replace(" ", "");
            if (names[i].isEmpty()) {
                throw new IllegalArgumentException("빈 이름은 사용할 수 없습니다.");
            }
        }
        return names;
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
                throw new IllegalArgumentException("이름은 영어와 숫자로만 구성되어야합니다.");
            }
        }
    }

    public void validateInput(List<String> cars) {
        checkEngAndNumber(cars);
        checkInputLength(cars);
        checkUniqueInput(cars);
    }

    public Long validateNumbers(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해야 합니다.");
        }
        try {
            long num = Long.parseLong(numbers); // 숫자인지 확인
            if (num <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            if (numbers.matches("\\d+")) { //숫자긴 한데 long의 범위를 넘긴 경우
                throw new IllegalArgumentException("최대 시도 횟수를 넘겼습니다.");
            }
            throw new IllegalArgumentException("정수를 입력해야 합니다.");
        }
        return Long.parseLong(numbers);
    }

}
