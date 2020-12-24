import java.util.regex.Pattern;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

class Matrix {
    private static final Pattern SPACE = Pattern.compile("\\s");
    private final int[] cells;
    private final int rows;
    private final int cols;

    Matrix(String matrixAsString) {
        rows = (int) matrixAsString.lines().count();
        cells = SPACE.splitAsStream(matrixAsString).mapToInt(Integer::parseInt).toArray();
        cols = cells.length / rows;
    }

    int[] getRow(int rowNumber) {
        return stream(cells, cols * (rowNumber - 1), cols * rowNumber).toArray();
    }

    int[] getColumn(int columnNumber) {
        return range(0, rows).map(i -> cells[i * cols + columnNumber - 1]).toArray();
    }

}