import java.util.regex.Pattern;

import static java.util.Arrays.copyOfRange;
import static java.util.stream.IntStream.range;

class Matrix {
    private static final Pattern SPACE = Pattern.compile("\\s");

    private final int[] matrix;
    private final int rows;
    private final int cols;

    Matrix(final String matrixAsString) {
        rows = (int) matrixAsString.lines().count();
        matrix = SPACE.splitAsStream(matrixAsString).mapToInt(Integer::parseInt).toArray();
        cols = matrix.length / rows;
    }

    int[] getRow(final int rowNumber) {
        return copyOfRange(matrix, cols * (rowNumber - 1), cols * rowNumber);
    }

    int[] getColumn(final int columnNumber) {
        return range(0, rows).map(i -> matrix[i * cols + columnNumber - 1]).toArray();
    }

}