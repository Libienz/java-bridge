package bridge.dto;

import bridge.domain.Direction;

public class RoundResultDto {

    private final Direction moveDirection;
    private final boolean moveSuccess;

    public RoundResultDto(Direction moveDirection, boolean moveSuccess) {
        this.moveDirection = moveDirection;
        this.moveSuccess = moveSuccess;
    }

    public Direction getMoveDirection() {
        return moveDirection;
    }

    public boolean isMoveSuccess() {
        return moveSuccess;
    }
}
