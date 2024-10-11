package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.Lotto;
import lotto.util.InputValidator;
import lotto.util.LottoMessage;
import lotto.util.Parser;

public class InputView {
    public static int readUserMoney() {
        System.out.print(LottoMessage.GAME_START_MESSAGE);
        String userInput = Console.readLine();

        InputValidator.validateMoneyInput(userInput);

        return Integer.parseInt(userInput);
    }

    public static Lotto readLottoNumber() {
        System.out.print(LottoMessage.LOTTO_NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        InputValidator.validateLottoInput(userInput);

        return new Lotto(Parser.parseInputToList(userInput));
    }
}
