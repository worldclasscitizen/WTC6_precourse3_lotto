package lotto.view;

import java.util.List;
import lotto.game.Lotto;
import lotto.game.Constants;
import lotto.util.LottoMessage;

public class OutputView {
    public static void printStartGame() {
        System.out.print(LottoMessage.GAME_START_MESSAGE);
    }

    public static void printPurchasedLotto(List<Lotto> lottoList) {
        System.out.printf(LottoMessage.LOTTO_PURCHASED_MESSAGE, lottoList.size());
        lottoList.forEach(lotto -> {
            System.out.println("[" + lotto.getLottoNumbers() + "]");
        });
    }

    public static void printResult() {
        printPrizes();
        printInterest();
    }

    private static void printPrizes() {
        System.out.print(LottoMessage.RESULT_MESSAGE);
        System.out.print(LottoMessage.DIVIDER);
        System.out.printf(LottoMessage.FIFTH_GRADE_MESSAGE, Constants.fifth);
        System.out.printf(LottoMessage.FOURTH_GRADE_MESSAGE, Constants.fourth);
        System.out.printf(LottoMessage.THIRD_GRADE_MESSAGE, Constants.third);
        System.out.printf(LottoMessage.SECOND_GRADE_MESSAGE, Constants.second);
        System.out.printf(LottoMessage.FIRST_GRADE_MESSAGE, Constants.first);
    }

    private static void printInterest() {
        System.out.printf(LottoMessage.INTEREST_MESSAGE, Constants.interest);
    }
}
