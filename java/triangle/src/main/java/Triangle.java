class Triangle {
    private final double side1;
    private final double side2;
    private final double side3;

    Triangle(double side1, double side2, double side3) throws TriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    boolean isEquilateral() {
        return true;
    }

    boolean isIsosceles() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    boolean isScalene() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
