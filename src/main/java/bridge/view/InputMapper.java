package bridge.view;

import bridge.domain.Direction;
import bridge.domain.GameCommand;

public class InputMapper {
    private static final String NON_NUMERIC_VALUE_MESSAGE = "[ERROR] 숫자로 된 값이 아닙니다";

    public int mapToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_VALUE_MESSAGE);
        }
    }

    public Direction mapToDirection(String input) {
        return Direction.from(input);
    }

    public GameCommand mapToGameCommand(String input) {
        return GameCommand.from(input);
    }
}
