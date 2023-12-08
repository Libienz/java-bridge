package bridge;

import bridge.config.BridgeGameConfig;
import bridge.domain.BridgeGame;

public class Application {

    public static void main(String[] args) {

        BridgeGameConfig bridgeGameConfig = new BridgeGameConfig();
        bridgeGameConfig.bridgeGameController().run();
    }

}
