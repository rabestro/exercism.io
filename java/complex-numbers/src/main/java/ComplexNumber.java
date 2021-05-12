public class ComplexNumber {
    private double real;
    private double imag;

    ComplexNumber(double r, double i) {
        this.real = r;
        this.imag = i;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public ComplexNumber times(ComplexNumber complexNumber) {
        return new ComplexNumber(-1.0, 0);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber minus(ComplexNumber complexNumber) {
        return null;
    }

    public ComplexNumber div(ComplexNumber complexNumber) {
        return null;
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imag);
    }

    public ComplexNumber exponentialOf() {
        return null;
    }
}