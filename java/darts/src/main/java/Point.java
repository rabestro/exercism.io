public record Point(double x, double y) {
    public boolean isHit(Ring ring) {
        return Math.sqrt(x * x + y * y) <= ring.radius();
    }
}
