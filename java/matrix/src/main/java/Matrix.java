import java.util.Scanner;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

class Matrix {
    final int[] cells;
    final int rows;
    final int cols;

    Matrix(String matrixAsString) {
        rows = (int) matrixAsString.lines().count();
        cells = new Scanner(matrixAsString).tokens().mapToInt(Integer::parseInt).toArray();
        cols = cells.length / rows;
    }

    int[] getRow(int rowNumber) {
        return stream(cells, cols * (rowNumber - 1), cols * rowNumber).toArray();
    }

    int[] getColumn(int columnNumber) {
        return range(0, rows).map(i -> cells[i * cols + columnNumber - 1]).toArray();
    }
}
