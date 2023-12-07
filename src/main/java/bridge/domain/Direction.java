package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP("U", 1),
    DOWN("D", 0);

    private static final String NO_SUCH_DIRECTION_MESSAGE = "[ERROR] 입력된 방향은 존재하지 않는 방향입니다.";
    private final String inputCode;
    private final int numberCode;

    Direction(String inputCode, int numberCode) {
        this.inputCode = inputCode;
        this.numberCode = numberCode;
    }

    public static Direction from(String inputCode) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.inputCode.equals(inputCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_DIRECTION_MESSAGE));
    }

    public static Direction from(int numberCode) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.numberCode == numberCode)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_DIRECTION_MESSAGE));
    }

    public String getInputCode() {
        return inputCode;
    }

    public int getNumberCode() {
        return numberCode;
    }
}
