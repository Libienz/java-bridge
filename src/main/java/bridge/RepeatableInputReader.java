package bridge;

import java.util.function.Supplier;

public class RepeatableInputReader {
    private final InputView inputView;

    public RepeatableInputReader(InputView inputView) {
        this.inputView = inputView;
    }

    private <T> T requestInputUntilPassItsValidation(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
