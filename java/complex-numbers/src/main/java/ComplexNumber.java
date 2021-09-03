public class ComplexNumber {
    private double real;
    private double imag;

    ComplexNumber(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public ComplexNumber times(ComplexNumber other) {
        return new ComplexNumber(
                real * other.real - imag * other.imag,
                imag * other.real + real * other.imag);
    }

    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(this.real + other.real, this.imag + other.imag);
    }

    public ComplexNumber minus(ComplexNumber other) {
        return new ComplexNumber(this.real - other.real, this.imag - other.imag);
    }

    public ComplexNumber div(ComplexNumber other) {
        return new ComplexNumber(
                (real * other.real + imag * other.imag) / (other.real * other.real + other.imag * other.imag),
                (imag * other.real - real * other.imag) / (other.real * other.real + other.imag * other.imag));
    }

    public double abs() {
        return Math.sqrt(real * real + imag * imag);
    }

    public ComplexNumber conjugate() {
        return new ComplexNumber(real, -imag);
    }

    public ComplexNumber exponentialOf() {
        final var k = Math.pow(Math.E, real);
        return new ComplexNumber(k * Math.cos(imag), k * Math.sin(imag));
    }
}