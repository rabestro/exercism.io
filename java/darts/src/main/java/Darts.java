record Darts() {
    private static final int OUTER_CIRCLE = 100;
    private static final int MIDDLE_CIRCLE = 25;
    private static final int INNER_CIRCLE = 1;

    int score(double x, double y) {
        var distance = x * x + y * y;

        if (distance > OUTER_CIRCLE) {
            return 0;
        }
        if (distance > MIDDLE_CIRCLE) {
            return 1;
        }
        if (distance > INNER_CIRCLE) {
            return 5;
        }
        return 10;
    }
}
