public class ComplexNumber {
    private double a;
    private double b;

    ComplexNumber(double real, double imag) {
        this.a = real;
        this.b = imag;
    }

    public double getReal() {
        return a;
    }

    public double getImag() {
        return b;
    }

    public ComplexNumber times(ComplexNumber other) {
        return new ComplexNumber(a * other.a - b * other.b, b * other.a + a * other.b);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.a + other.a, this.b + other.b);
    }

    public ComplexNumber minus(ComplexNumber other) {
        return new ComplexNumber(this.a - other.a, this.b - other.b);
    }

    // Dividing a complex number a + i * b by another c + i * d gives:
    // (a + i * b) / (c + i * d) =
    // (a * c + b * d)/(c^2 + d^2) + (b * c - a * d)/(c^2 + d^2) * i

    public ComplexNumber div(ComplexNumber o) {
        return new ComplexNumber(
                (a * o.a + b * o.b) / (o.a * o.a + o.b * o.b),
                (b * o.a - a * o.b) / (o.a * o.a + o.b * o.b));
    }

    public double abs() {
        return Math.sqrt(a * a + b * b);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(a, -b);
    }

    public ComplexNumber exponentialOf() {
        return null;
    }
}