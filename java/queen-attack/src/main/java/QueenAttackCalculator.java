import static java.lang.Math.abs;

final class Queen {
    final int row;
    final int col;

    public Queen(final int row, final int col) {
        checkArgument(row >= 0, "Queen position must have positive row.");
        checkArgument(col >= 0, "Queen position must have positive column.");
        checkArgument(row <= 7, "Queen position must have row <= 7.");
        checkArgument(col <= 7, "Queen position must have column <= 7.");

        this.row = row;
        this.col = col;
    }

    private static void checkArgument(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
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