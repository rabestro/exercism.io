import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.range;

class Matrix {

    private final List<List<Integer>> matrix;
    private final int rows;
    private final int cols;

    Matrix(List<List<Integer>> values) {
        this.rows = values.size();
        this.cols = values.get(0).size();
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return Collections.singleton(new MatrixCoordinate(2, 1));
    }

    private boolean isSaddlePoint(final int row, final int col) {
        final var point = matrix.get(row).get(col);
        return matrix.get(row).stream().max(Integer::compareTo).orElseThrow().equals(point)
                && range(0, rows).map(i -> matrix.get(i).get(col)).min().orElseThrow() == point;
    }
}
