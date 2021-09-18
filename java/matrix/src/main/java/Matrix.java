import java.util.Arrays;
import java.util.Scanner;

class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        matrix = matrixAsString.lines()
                .map(this::parseLine)
                .toArray(int[][]::new);
    }

    private int[] parseLine(String line) {
        return new Scanner(line).tokens().mapToInt(Integer::parseInt).toArray();
    }

    int[] getRow(int rowNumber) {
        return Arrays.copyOf(matrix[rowNumber - 1], matrix[0].length);
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(ints -> ints[columnNumber - 1]).toArray();
    }

}