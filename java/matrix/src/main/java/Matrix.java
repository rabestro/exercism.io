import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

class Matrix {
    private final int[][] matrix;

    Matrix(String matrixAsString) {
        matrix = matrixAsString.lines()
                .map(Scanner::new)
                .map(Scanner::tokens)
                .map(s -> s.mapToInt(Integer::parseInt))
                .map(IntStream::toArray)
                .toArray(int[][]::new);
    }

    int[] getRow(int rowNumber) {
        return Arrays.copyOf(matrix[rowNumber - 1], matrix[0].length);
    }

    int[] getColumn(int columnNumber) {
        return Arrays.stream(matrix).mapToInt(ints -> ints[columnNumber - 1]).toArray();
    }

}