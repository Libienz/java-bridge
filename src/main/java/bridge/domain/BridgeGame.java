package bridge.domain;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;
    private static final String INVALID_LENGTH_BRIDGE_MESSAGE = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private final List<Direction> escapeRoute;
    private int userPosition = 0;

    private BridgeGame(List<Direction> escapeRoute) {
        validate(escapeRoute);
        this.escapeRoute = escapeRoute;
    }

    public static BridgeGame from(List<String> directions) {
        List<Direction> escapeRoute = directions.stream()
                .map(Direction::from)
                .collect(Collectors.toList());
        return new BridgeGame(escapeRoute);
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Direction direction) {
        if (escapeRoute.get(userPosition).equals(direction)) {
            userPosition++;
            return true;
        }
        return false;
    }

    public boolean isGameEnd () {
        return userPosition == escapeRoute.size();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        userPosition = 0;
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
