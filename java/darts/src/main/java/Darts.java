import java.util.Arrays;
import java.util.Comparator;

record Darts() {
    int score(double x, double y) {
        return Arrays.stream(Ring.values())
                .sorted(Comparator.comparingInt(Ring::radius))
                .filter(new Point(x, y)::isHit)
                .findFirst()
                .map(Ring::points)
                .orElse(0);
    }
}
