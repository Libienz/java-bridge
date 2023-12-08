package bridge.dto;

import java.util.List;

public class RoundResultsDto {
    private final List<RoundResultDto> roundResultDtos;

    public RoundResultsDto(List<RoundResultDto> roundResultDtos) {
        this.roundResultDtos = roundResultDtos;
    }

    public List<RoundResultDto> getRoundResultDtos() {
        return roundResultDtos;
    }
}
