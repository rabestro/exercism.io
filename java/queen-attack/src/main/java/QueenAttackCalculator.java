import java.util.Map;
import java.util.function.Supplier;
import static java.lang.Math.abs;

class Queen {
    final int x;
    final int y;

    public Queen(int x, int y) {
        final Map<String, Supplier<Boolean>> validationRules = Map.of(
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
    private final Queen white;
    private final Queen black;

    public QueenAttackCalculator(Queen white, Queen black) {
        this.white = white;
        this.black = black;
    }

    public boolean canQueensAttackOneAnother() {
        return white.x == black.x || white.y == black.y
                || abs(white.x - black.x) == abs(white.y - black.y);
    }
}