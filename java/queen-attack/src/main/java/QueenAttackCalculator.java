import java.util.Map;
import java.util.function.Supplier;

import static java.lang.Math.abs;

final class Queen {
    final int x;
    final int y;

    public Queen(final int x, final int y) {
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

public final class QueenAttackCalculator {
    private final Queen white;
    private final Queen black;

    public QueenAttackCalculator(final Queen white, final Queen black) {
        if (white == null || black == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (white.x == black.x && white.y == black.y) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.white = white;
        this.black = black;
    }

    public boolean canQueensAttackOneAnother() {
        return white.x == black.x || white.y == black.y
                || abs(white.x - black.x) == abs(white.y - black.y);
    }
}