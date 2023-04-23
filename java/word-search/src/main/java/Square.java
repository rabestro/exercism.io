import java.util.Optional;

public final class Square {
    private final char[][] grid;
    private final int rows;
    private final int cols;

    public Square(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }
    
    public Optional<WordLocation> wordLocation(String word) {
        return Optional.empty();
    }
}
