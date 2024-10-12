package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.game.Lotto;
import lotto.util.InputValidator;
import lotto.util.LottoMessage;
import lotto.util.Parser;

public class InputView {
    public static int readUserMoney() {
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

    public static int readBonusNumber() {
        System.out.print(LottoMessage.BONUS_NUMBER_INPUT_MESSAGE);
        String userInput = Console.readLine();

        InputValidator.isNumeric(userInput);

        return Parser.convertToInteger(userInput);
    }
}
