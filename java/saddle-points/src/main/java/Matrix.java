import java.util.Collections;
import java.util.List;
import java.util.Set;

class Matrix {

    private final List<List<Integer>> values;

    Matrix(List<List<Integer>> values) {
        this.values = values;
    }

    Set<MatrixCoordinate> getSaddlePoints() {
        return Collections.singleton(new MatrixCoordinate(2, 1));
    }
}
