package bridge.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("게임 재시작 커맨드 테스트")
class GameCommandTest {

    @DisplayName("올바른 게임 커맨드가 입력되면 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void testGameCommandResolveWithValidInput(String command) {
        assertThatNoException().isThrownBy(() -> GameCommand.from(command));
    }

    @DisplayName("잘못된 게임 커맨드가 입력되면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"Y", "N", "1", "YES"})
    void testGameCommandResolveWithInValidInput(String command) {
        assertThatThrownBy(() -> GameCommand.from(command))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 올바르지 않은 게임 커맨드 입니다");
    }
}