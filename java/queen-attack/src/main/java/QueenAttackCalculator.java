class Queen {
    private final int x;
    private final int y;

    public Queen(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Queen position must have positive row.");
        }
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