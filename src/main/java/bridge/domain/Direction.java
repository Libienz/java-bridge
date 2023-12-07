package bridge.domain;

import java.util.Arrays;

public enum Direction {
    UP("U"),
    DOWN("D");

    private static final String NO_SUCH_DIRECTION_MESSAGE = "[ERROR] 입력된 방향은 존재하지 않는 방향입니다.";
    private final String code;

    Direction(String code) {
        this.code = code;
    }

    public static Direction from(String code) {
        return Arrays.stream(Direction.values())
                .filter(direction -> direction.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NO_SUCH_DIRECTION_MESSAGE));
    }

    public String getCode() {
        return code;
    }
}
