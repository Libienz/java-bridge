package bridge.dto;

public class GameResultDto {
    private final RoundResultsDto roundResultsDto;
    private final int retryCount;
    private final boolean gameSuccess;

    public GameResultDto(RoundResultsDto roundResultsDto, int retryCount, boolean gameSuccess) {
        this.roundResultsDto = roundResultsDto;
        this.retryCount = retryCount;
        this.gameSuccess = gameSuccess;
    }

    public RoundResultsDto getRoundResultsDto() {
        return roundResultsDto;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean isGameSuccess() {
        return gameSuccess;
    }
}
