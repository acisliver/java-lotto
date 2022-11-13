package lotto.controller;

import lotto.controller.validator.MoneyValidator;
import lotto.service.LottoGameService;

public class LottoController implements Controller {

    private final LottoGameService service;

    public LottoController(LottoGameService service) {
        this.service = service;
    }

    public void inputMoney(String input) {
        validateInput(input, MoneyValidator.values());
    }

    }
}
