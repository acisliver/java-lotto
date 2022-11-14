package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottosTest {

    @DisplayName("로또 묶음에서 로또의 개수를 확인한다.")
    @Test
    void size() {
        // given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(list);
        List<Lotto> givenLottos = List.of(lotto);

        // when
        Lottos lottos = new Lottos(givenLottos);

        // then
        assertThat(lottos.size()).isEqualTo(givenLottos.size());
    }
}
