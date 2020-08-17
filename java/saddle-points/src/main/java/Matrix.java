import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class Matrix {

    private final List<List<Integer>> matrix;
    private final int rows;
    private final int cols;

    Matrix(List<List<Integer>> values) {
        this.rows = values.size();
        this.cols = rows > 0 ? values.get(0).size() : 0;
        this.matrix = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return range(0, rows).boxed()
                .flatMap(row -> range(0, cols)
                        .filter(col -> isSaddlePoint(row, col))
                        .mapToObj(col -> new MatrixCoordinate(row + 1, col + 1)))
                .collect(Collectors.toSet());
    }

    private boolean isSaddlePoint(final int row, final int col) {
        final var point = matrix.get(row).get(col);
        return matrix.get(row).stream().max(Integer::compareTo).orElseThrow().equals(point)
                && range(0, rows).map(i -> matrix.get(i).get(col)).min().orElseThrow() == point;
    }
}
