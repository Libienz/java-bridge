package bridge.view;

import bridge.dto.GameResultDto;
import bridge.dto.RoundResultsDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GREETING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private final OutputMessageResolver outputMessageResolver;

    public OutputView(OutputMessageResolver outputMessageResolver) {
        this.outputMessageResolver = outputMessageResolver;
    }

    public void printGreeting() {
        System.out.println(GREETING_MESSAGE);
    }
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(RoundResultsDto roundResultsDto) {
        System.out.println(outputMessageResolver.resolveRoundResultMessage(roundResultsDto));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(GameResultDto gameResultDto) {
        System.out.println(outputMessageResolver.resolveGameResultMessage(gameResultDto));
    }
}
