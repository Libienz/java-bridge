package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private static final String INVALID_GAME_COMMAND_MESSAGE = "[ERROR] 올바르지 않은 게임 커맨드 입니다";

    private String code;

    GameCommand(String code) {
        this.code = code;
    }

    public static GameCommand from(String input) {
        return Arrays.stream(GameCommand.values())
                .filter(command -> input.equals(command.code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_GAME_COMMAND_MESSAGE));
    }
    public String getCode() {
        return code;
    }
}
