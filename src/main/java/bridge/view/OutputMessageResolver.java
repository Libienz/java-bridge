package bridge.view;

import bridge.domain.Direction;
import bridge.dto.RoundResultDto;
import bridge.dto.RoundResultsDto;

import java.util.List;

public class OutputMessageResolver {

    private static final String ROUND_MESSAGE_PREFIX = "[";
    private static final String ROUND_MESSAGE_POSTFIX = "]";
    private static final String SEPARATOR = "|";
    private static final String MOVE_SUCCESS_MARK = " O ";
    private static final String MOVE_FAIL_MARK = " X ";
    private static final String MOVE_NONE_MARK = "   ";

    public String resolveRoundResultMessage(RoundResultsDto roundResultsDto) {

        List<RoundResultDto> roundResultDtos = roundResultsDto.getRoundResultDtos();
        String upDirectionFootPrint = ROUND_MESSAGE_PREFIX;
        String downDirectionFootPrint = ROUND_MESSAGE_PREFIX;
        for (RoundResultDto roundResultDto : roundResultDtos) {
            if (roundResultDto.getMoveDirection() == Direction.UP) {
                upDirectionFootPrint += mapToMoveMark(roundResultDto.isMoveSuccess()) + SEPARATOR;
                downDirectionFootPrint += MOVE_NONE_MARK + SEPARATOR;
            }
            if (roundResultDto.getMoveDirection() == Direction.DOWN) {
                upDirectionFootPrint += MOVE_NONE_MARK + SEPARATOR;
                downDirectionFootPrint += mapToMoveMark(roundResultDto.isMoveSuccess()) + SEPARATOR;
            }
        }

        upDirectionFootPrint = upDirectionFootPrint.substring(0, upDirectionFootPrint.length() - 1);
        downDirectionFootPrint = downDirectionFootPrint.substring(0, downDirectionFootPrint.length() - 1);
        return upDirectionFootPrint + ROUND_MESSAGE_POSTFIX + "\n" + downDirectionFootPrint + ROUND_MESSAGE_POSTFIX;
    }

    private String mapToMoveMark(boolean moveSuccess) {
        if (!moveSuccess) {
            return MOVE_FAIL_MARK;
        }
        return MOVE_SUCCESS_MARK;
    }
}
