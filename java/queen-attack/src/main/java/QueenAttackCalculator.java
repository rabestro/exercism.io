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

    static void checkArgument(boolean condition, String message) {
        if (!condition) {
            throw new IllegalArgumentException(message);
        }
    }

    boolean hasSameRow(Queen other) {
        return this.row == other.row;
    }

    boolean hasSameCol(Queen other) {
        return this.col == other.col;
    }

    boolean hasSameDiagonal(Queen other) {
        return Math.abs(this.row - other.row) == Math.abs(this.col - other.col);
    }

    boolean hasSamePosition(Queen other) {
        return this.row == other.row && this.col == other.col;
    }
}

public final class QueenAttackCalculator {
    private final Queen white;
    private final Queen black;

    public QueenAttackCalculator(final Queen white, final Queen black) {
        Queen.checkArgument(white != null && black != null,
                "You must supply valid positions for both Queens.");
        Queen.checkArgument(!white.hasSamePosition(black),
                "Queens cannot occupy the same position.");
        this.white = white;
        this.black = black;
    }

    public boolean canQueensAttackOneAnother() {
        return white.hasSameRow(black)
                || white.hasSameCol(black)
                || white.hasSameDiagonal(black);
    }
}