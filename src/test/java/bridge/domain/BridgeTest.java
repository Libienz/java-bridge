package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static bridge.domain.Direction.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("다리 테스트")
class BridgeTest {

    @DisplayName("범위를 벗어나는 길이의 다리 생성 요청 시 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 21, 22})
    void testCreateWithInvalidLength(int length) {
        List<Direction> escapeRoute = new ArrayList<>();
        IntStream.range(0, length)
                .mapToObj(i -> UP)
                .forEach(escapeRoute::add);
        assertThatThrownBy(() -> new Bridge(escapeRoute))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
    }

    @DisplayName("정상적인 다리 생성 요청 시 예외가 발생하지 않음")
    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5, 19, 20})
    void testCreateWithValidRoute(int length) {
        List<Direction> escapeRoute = new ArrayList<>();
        IntStream.range(0, length)
                .mapToObj(i -> UP)
                .forEach(escapeRoute::add);
        assertThatNoException().isThrownBy(() -> new Bridge(escapeRoute));
    }
}