import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

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
        int mines = 0;
        for (int i = max(0, row - 1); i < min(rows, row + 2); i++) {
            for (int j = max(0, col - 1); j < min(cols, col + 2); j++) {
                if (inputBoard.get(i).charAt(j) == '*') {
                    mines++;
                }
            }
        }
        return mines;
    }
}