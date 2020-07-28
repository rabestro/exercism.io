import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Queen {
    private final int x;
    private final int y;

    public Queen(int x, int y) {
        Map<String, Supplier<Boolean>> validationRules = Map.of(
                "Queen position must have positive row.", () -> x < 0,
                "Queen position must have positive column.", () -> y < 0,
                "Queen position must have row <= 7.", () -> x > 7,
                "Queen position must have column <= 7.", () -> y > 7);

        validationRules.entrySet().stream()
                .filter(validation -> validation.getValue().get())
                .forEach(validation -> {
                    throw new IllegalArgumentException(validation.getKey());
                });

        this.x = x;
        this.y = y;
    }
}

public class QueenAttackCalculator {

    public QueenAttackCalculator(Queen white, Queen black) {
    }

    public boolean canQueensAttackOneAnother() {
        return true;
    }
}