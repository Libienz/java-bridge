package bridge.domain;

import java.util.List;

public class Bridge {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final String INVALID_LENGTH_BRIDGE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final List<Direction> escapeRoute;

    public Bridge(List<Direction> escapeRoute) {
        validate(escapeRoute);
        this.escapeRoute = escapeRoute;
    }

    private void validate(List<Direction> escapeRoute) {
        validateLength(escapeRoute);
    }

    private void validateLength(List<Direction> escapeRoute) {
        if (escapeRoute.size() < MIN_LENGTH || escapeRoute.size() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_BRIDGE_MESSAGE);
        }
    }
}
