package bridge.config;

import bridge.controller.BridgeGameController;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.domain.BridgeRandomNumberGenerator;
import bridge.view.InputMapper;
import bridge.view.InputView;
import bridge.view.OutputMessageResolver;
import bridge.view.OutputView;

public class BridgeGameConfig {
    public BridgeGameController bridgeGameController() {
        return new BridgeGameController(bridgeMaker(), inputView(), outputView());
    }

    public BridgeMaker bridgeMaker() {
        return new BridgeMaker(bridgeNumberGenerator());
    }

    public BridgeNumberGenerator bridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    public InputView inputView() {
        return new InputView(inputMapper());
    }

    public InputMapper inputMapper() {
        return new InputMapper();
    }

    public OutputView outputView() {
        return new OutputView(outputMessageResolver());
    }

    public OutputMessageResolver outputMessageResolver() {
        return new OutputMessageResolver();
    }
}
