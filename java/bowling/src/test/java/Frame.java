final class Frame {
    private static final int MAX_PINS = 10;
    private final int first;
    private final int second;
    private final int third;

    Frame(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    int score() {
        return first + second + third;
    }

    boolean isStrike() {
        return first == MAX_PINS;
    }

    boolean isSpare() {
        return !isStrike() && (first + second) == MAX_PINS;
    }
}
