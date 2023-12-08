package bridge.view;

import bridge.domain.Direction;
import bridge.domain.GameCommand;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String INPUT_BRIDGE_LENGTH_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVE_DIRECTION_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String INPUT_RETRY_COMMAND_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private final InputMapper inputMapper;

    public InputView(InputMapper inputMapper) {
        this.inputMapper = inputMapper;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH_MESSAGE);
        return inputMapper.mapToInt(Console.readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Direction readMoving() {
        System.out.println(INPUT_MOVE_DIRECTION_MESSAGE);
        return inputMapper.mapToDirection(Console.readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameCommand readGameCommand() {
        System.out.println(INPUT_RETRY_COMMAND_MESSAGE);
        return inputMapper.mapToGameCommand(Console.readLine());
    }
}
