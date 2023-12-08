package bridge;

import bridge.domain.Direction;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("메시지 리졸버 테스트")
class OutputMessageResolverTest {
    private OutputMessageResolver outputMessageResolver;

    @BeforeEach
    void setUp() {
        outputMessageResolver = new OutputMessageResolver();
    }

    @DisplayName("라운드 결과 메시지 생성 테스트")
    @Test
    void testResolveRoundMessageResolve() {
        List<RoundResultDto> roundResultDtos = List.of(new RoundResultDto(Direction.UP, true), new RoundResultDto(Direction.UP, true), new RoundResultDto(Direction.DOWN, false));
        RoundResultsDto roundResultsDto = new RoundResultsDto(roundResultDtos);

        assertThat(outputMessageResolver.resolveRoundResultMessage(roundResultsDto)).isEqualTo("[ O | O |   ]\n" + "[   |   | X ]");
        System.out.println();
    }
}