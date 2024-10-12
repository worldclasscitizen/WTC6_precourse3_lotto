package lotto;

import lotto.game.LottoController;

public class Application {
    public static void main(String[] args) {
        LottoController controller = new LottoController();
        controller.start();
    }
}