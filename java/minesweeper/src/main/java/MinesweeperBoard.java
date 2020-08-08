import java.util.ArrayList;
import java.util.List;

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
        final var list = new ArrayList<String>();
        for (int row = 0; row < rows; row++) {
            var line = new char[cols];
            for (int col = 0; col < cols; col++) {
                if (inputBoard.get(row).charAt(col) == '*') {
                    line[col] = '*';
                } else {
                    int mines = countMines(row, col);
                    if (mines == 0) {
                        line[col] = ' ';
                    } else {
                        line[col] = Character.forDigit(mines, 10);
                    }
                }
            }
            list.add(new String(line));
        }
        return list;
    }

    private int countMines(final int row, final int col) {
        return (int) range(max(0, row - 1), min(rows, row + 2))
                .flatMap(i -> range(max(0, col - 1), min(cols, col + 2))
                        .filter(j -> inputBoard.get(i).charAt(j) == '*'))
                .count();
    }
}
