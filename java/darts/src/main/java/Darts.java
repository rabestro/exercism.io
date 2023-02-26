import java.util.stream.Stream;

record Darts() {
    int score(double x, double y) {
        return Stream
                .of(Ring.INNER, Ring.MIDDLE, Ring.OUTER)
                .filter(new Point(x, y)::isHit)
                .findFirst()
                .map(Ring::points)
                .orElse(0);
    }
}
