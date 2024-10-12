package lotto.game;

import java.util.List;
import lotto.view.OutputView;

public class LottoController {
    private static Computer computer;
    private static List<Lotto> purchasedLottoList;

    public LottoController() {
        computer = new Computer();
    }

    public void start() {
        play();
    }


    private void play() {
        readMoneyInput();

        purchaseLotto();

        readLottoNumber();
        readBonusNumber();

        computer.calculateWonLotto();
        computer.calculateInterest();
        OutputView.printResult();
    }

    private void readMoneyInput() {
        OutputView.printStartGame();
        computer.inputTimes();
    }

    private void purchaseLotto() {
        purchasedLottoList = computer.createLottoList();
        OutputView.printPurchasedLotto(purchasedLottoList);
    }

    private void readLottoNumber() {
        computer.inputWinningLotto();
    }

    private void readBonusNumber() {
        computer.inputBonusNumber();
    }
}