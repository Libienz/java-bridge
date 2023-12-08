package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("다리 생성기 테스트")
class BridgeMakerTest {
    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("사이즈를 전달하면 사이즈 크기의 다리를 생성한다")
    @Test
    void testCreatedBridgeSize() {
        assertThat(bridgeMaker.makeBridge(10).size()).isEqualTo(10);
    }

    @DisplayName("생성된 다리의 정보는 배열로 각 원소는 U 또는 D로 이루어진 문자열이다")
    @Test
    void testBridgeContents() {
        List<String> bridge = bridgeMaker.makeBridge(10);
        boolean allMatch = bridge.stream()
                .allMatch(direction -> direction.equals("U") || direction.equals("D"));
        assertThat(allMatch).isTrue();
    }
}