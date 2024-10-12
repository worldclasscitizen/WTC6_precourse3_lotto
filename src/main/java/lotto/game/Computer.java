package lotto.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;
import lotto.view.InputView;

public class Computer {
    private static int times;
    private static final int PRICE_UNIT = 1000;
    private static List<Lotto> lottoList = new ArrayList<>();

    private static Lotto winningLotto;
    private static int bonusNumber;


    public static void inputTimes() {
        times = InputView.readUserMoney() / PRICE_UNIT;
    }

    public static void inputWinningLotto() {
        winningLotto = InputView.readLottoNumber();
    }

    public static void inputBonusNumber() {
        bonusNumber = InputView.readBonusNumber();
    }

    public static List<Lotto> createLottoList() {
        for(int i = 0; i < times; i++) {
            lottoList.add(createLotto());
        }
        return lottoList;
    }

    public static void calculateWonLotto() {
        lottoList.forEach(lotto -> {
            prizeCheck(lotto);
        });
    }

    public static void calculateInterest() {
        float asset = times * 1000;
        float sum = Constants.fifth * Constants.FIFTH_PRIZE;
        sum += Constants.fourth * Constants.FOURTH_PRIZE;
        sum += Constants.third * Constants.THIRD_PRIZE;
        sum += Constants.second * Constants.SECOND_PRIZE;
        sum += Constants.first * Constants.FIRST_PRIZE;

        Constants.interest = (sum / asset) * 100;
    }

    private static void prizeCheck(Lotto lotto) {
        Set<Integer> merged = new HashSet<>(lotto.getLottoNumbers());
        merged.addAll(winningLotto.getLottoNumbers());

        if(merged.size() > 9) {
        } else if(merged.size() == 9) {
            Constants.fifth++;
        } else if(merged.size() == 8) {
            Constants.fourth++;
        } else if(merged.size() == 7) {
            determineSecondAndThirdPrize(lotto);
        } else if(merged.size() == 6) {
            Constants.first++;
        } else if(merged.size() < 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LIST_SIZE);
        }
    }

    private static void determineSecondAndThirdPrize(Lotto lotto) {
        List<Integer> numbers = lotto.getLottoNumbers();
        if (numbers.contains(bonusNumber)) {
            Constants.second++;
        }
        if (!numbers.contains(bonusNumber)) {
            Constants.third++;
        }
    }

    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
