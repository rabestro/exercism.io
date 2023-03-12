import java.util.Arrays;
import java.util.regex.Pattern;

final class Matrix {
    private static final Pattern SPACE = Pattern.compile("\\s");
    private final int[][] cells;

    Matrix(String matrixAsString) {
        cells = matrixAsString.lines()
                .map(this::parseLine)
                .toArray(int[][]::new);
    }

    private int[] parseLine(String line) {
        return SPACE.splitAsStream(line)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    int[] getRow(int rowNumber) {
        return Arrays.copyOf(cells[rowNumber - 1], cells[0].length);
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(cells).mapToInt(ints -> ints[columnNumber - 1])
                .toArray();
    }

}
