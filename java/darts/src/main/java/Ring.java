enum Ring {
    INNER(1, 10),
    MIDDLE(5, 5),
    OUTER(10, 1);
    private final int radius;
    private final int points;

    Ring(int radius, int points) {
        this.radius = radius;
        this.points = points;
    }

    public int radius() {
        return radius;
    }

    public int points() {
        return points;
    }
}
