package lotto;

import lotto.game.Lotto;
import lotto.util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호의 개수가 6개보다 적으면 예외가 발생한다.")
    @Test
    void createLottoByUnderSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void validateLottoInputWithNumberOutOfRange() {
        String userInput = "1, 2, 3, 4, 5, 46";
        assertThatThrownBy(() -> InputValidator.validateLottoInput(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액은 1000원 단위로만 입력할 수 있다.")
    @Test
    void validateUserInputMoneyInUnitsOfThousand() {
        String userInput = "5001";
        boolean result = InputValidator.validateDivisibleByThousand(userInput);
        assertThat(result).isFalse();
    }
}