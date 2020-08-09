import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.IntStream.range;

public class MinesweeperBoard {
    private final List<String> inputBoard;
    private final int rows;
    private final int cols;

    public MinesweeperBoard(List<String> inputBoard) {
        this.inputBoard = inputBoard;
        rows = inputBoard.size();
        cols = rows > 0 ? inputBoard.get(0).length() : 0;
    }

    public List<String> withNumbers() {
        return range(0, rows).mapToObj(row -> range(0, cols)
                .map(col -> inputBoard.get(row).charAt(col) == '*' ? '*' : countMines(row, col))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString()
        ).collect(Collectors.toList());
    }

    private char countMines(final int row, final int col) {
        final int mines = (int) range(max(0, row - 1), min(rows, row + 2))
                .flatMap(i -> range(max(0, col - 1), min(cols, col + 2))
                        .filter(j -> inputBoard.get(i).charAt(j) == '*'))
                .count();
        return mines == 0 ? ' ' : Character.forDigit(mines, 10);
    }
}
