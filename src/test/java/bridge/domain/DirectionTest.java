package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("이동 방향 테스트")
class DirectionTest {
    @DisplayName("U 코드는 위로 인식한다")
    @Test
    void testResolveUcode() {
        assertThat(Direction.from("U")).isEqualTo(Direction.UP);
    }
    @DisplayName("D 코드는 아래로 인식한다")
    @Test
    void testResolveDcode() {
        assertThat(Direction.from("D")).isEqualTo(Direction.DOWN);
    }
}