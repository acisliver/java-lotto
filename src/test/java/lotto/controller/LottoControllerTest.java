package lotto.controller;

import lotto.ApplicationContext;
import lotto.controller.validator.MoneyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoControllerTest {

    private LottoController controller;

    @BeforeEach
    void init() {
        controller = ApplicationContext.getContext().getController();
    }

    @DisplayName("로또 구입 금액이 조건에 맞지 않으면 예외가 발생한다.")
    @Test
    void inputInvalidMoney() {
        assertAll(
                () -> assertThatThrownBy(() -> controller.inputMoney("non digit"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(MoneyValidator.IS_NATURAL_NUMBER.getErrorMessage())
        );
    }
}
