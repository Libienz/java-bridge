package bridge;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return inputMapper.mapToInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        return inputMapper.mapToDirection(Console.readLine());
    }
    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        return inputMapper.mapToGameCommand(Console.readLine());
    }
}
