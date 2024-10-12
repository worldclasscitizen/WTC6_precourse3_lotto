package lotto.game;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> target = new HashSet<>(numbers);

        if(target.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.IS_DUPLICATED);
        }
    }

    public List<Integer> getLottoNumbers() {
        return numbers;
    }
}