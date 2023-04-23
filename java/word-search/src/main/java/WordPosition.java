import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class WordPosition {
    private final char[][] grid;
    private final String word;
    private final int rows;
    private final int cols;

    public WordPosition(char[][] grid, String word) {
        this.grid = grid;
        this.word = word;
        this.rows = grid.length;
        this.cols = grid[0].length;
    }

    public Optional<WordLocation> get() {
        return findHorizontal();
    }

    Optional<WordLocation> findHorizontal() {
        return IntStream.range(0, rows)
                .mapToObj(row -> new Pair(new String(grid[row]).indexOf(word) + 1, row + 1))
                .filter(Pair::isValid)
                .findFirst()
                .map(s -> new WordLocation(s, new Pair(s.getX() + word.length() - 1, s.getY())));
    }

}
