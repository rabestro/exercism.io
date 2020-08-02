import java.util.Map;
import java.util.function.Supplier;

import static java.lang.Math.abs;

final class Queen {
    final int row;
    final int col;

    public Queen(final int row, final int col) {
        final Map<String, Supplier<Boolean>> validationRules = Map.of(
                "Queen position must have positive row.", () -> row < 0,
                "Queen position must have positive column.", () -> col < 0,
                "Queen position must have row <= 7.", () -> row > 7,
                "Queen position must have column <= 7.", () -> col > 7);

        validationRules.entrySet().stream()
                .filter(validation -> validation.getValue().get())
                .forEach(validation -> {
                    throw new IllegalArgumentException(validation.getKey());
                });

        this.row = row;
        this.col = col;
    }
}

public final class QueenAttackCalculator {
    private final Queen white;
    private final Queen black;

    public QueenAttackCalculator(final Queen white, final Queen black) {
        if (white == null || black == null) {
            throw new IllegalArgumentException("You must supply valid positions for both Queens.");
        }
        if (white.row == black.row && white.col == black.col) {
            throw new IllegalArgumentException("Queens cannot occupy the same position.");
        }
        this.white = white;
        this.black = black;
    }

    public boolean canQueensAttackOneAnother() {
        return white.row == black.row || white.col == black.col
                || abs(white.row - black.row) == abs(white.col - black.col);
    }
}