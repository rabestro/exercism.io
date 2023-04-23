class Pair {

    private final int x;

    private final int y;

    Pair(final int x, final int y) {
        this.y = y;
        this.x = x;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public boolean isValid() {
        return x > 0 && y > 0;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair pair = (Pair) o;

        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
