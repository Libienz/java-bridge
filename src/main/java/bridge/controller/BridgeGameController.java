package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.domain.Direction;
import bridge.domain.GameCommand;
import bridge.dto.GameResultDto;
import bridge.dto.RoundResultDto;
import bridge.dto.RoundResultsDto;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.util.Repeater;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController(BridgeMaker bridgeMaker, InputView inputView, OutputView outputView) {
        this.bridgeMaker = bridgeMaker;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printGreeting();
        BridgeGame bridgeGame = Repeater.repeatUntilNoException(this::createBridge);

        List<RoundResultDto> roundResults = new ArrayList<>();
        GameCommand gameCommand = GameCommand.RETRY;

        int tryCount = 1;
        while (!bridgeGame.isGameEnd() && gameCommand.equals(GameCommand.RETRY)) {

            RoundResultDto roundResultDto = executeRound(bridgeGame);
            roundResults.add(roundResultDto);
            outputView.printMap(new RoundResultsDto(roundResults));
            if (!roundResultDto.isMoveSuccess()) {
                gameCommand = Repeater.repeatUntilNoException(inputView::readGameCommand);
                tryCount++;
                roundResults.clear();
                bridgeGame.retry();
            }
        }
        outputView.printResult(new GameResultDto(new RoundResultsDto(roundResults), tryCount, bridgeGame.isGameEnd()));
    }

    private BridgeGame createBridge() {
        Integer length = Repeater.repeatUntilNoException(inputView::readBridgeSize);
        return BridgeGame.from(bridgeMaker.makeBridge(length));
    }

    private RoundResultDto executeRound(BridgeGame bridgeGame) {
        Direction direction = Repeater.repeatUntilNoException(inputView::readMoving);
        return new RoundResultDto(direction, bridgeGame.move(direction));
    }

}
