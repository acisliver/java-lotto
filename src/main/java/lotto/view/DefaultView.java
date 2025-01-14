package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.controller.LottoController;
import lotto.controller.dto.MoneyDto;
import lotto.controller.dto.WinningNumbersDto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.EnumMap;

public class DefaultView implements View {

    private final LottoController controller;

    public DefaultView(LottoController controller) {
        this.controller = controller;
    }

    public void render() {
        try {
            sendMoney();
            renderLottos();
            sendWinningNumbers();
            renderStatics();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    private void sendMoney() {
        System.out.println(Views.REQUEST_MONEY.render());
        String input = Console.readLine();

        MoneyDto moneyDto = new MoneyDto(input);
        controller.inputMoney(moneyDto);
    }

    private void sendWinningNumbers() {
        System.out.println(Views.REQUEST_WINNING_NUMBER.render());
        String winningNumber = Console.readLine();

        System.out.println(Views.REQUEST_BONUS_NUMBER.render());
        String bonusNumber = Console.readLine();

        WinningNumbersDto dto = new WinningNumbersDto(winningNumber, bonusNumber);
        controller.inputWinningNumbers(dto);
    }

    private void renderLottos() {
        Lottos lottos = controller.outputLottos();
        System.out.println(LottosView.LOTTOS_COUNT.render(lottos));
    }

    private void renderStatics() {
        System.out.println(Views.STATICS.render());
        System.out.println(Views.DIVIDER.render());

        EnumMap<LottoRank, Integer> lottoRanks = controller.outputRanks();
        System.out.println(RankView.render(lottoRanks));
        
        double profitRate = controller.getProfitRate(lottoRanks);
        System.out.println(ProfitView.PROFIT_RATE.render(profitRate));
    }

}
