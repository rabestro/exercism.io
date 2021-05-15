class Rational {
    private final int numerator;
    private final int denominator;

    Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    int getNumerator() {
        return numerator;
    }

    int getDenominator() {
        return denominator;
    }

    Rational add(Rational other) {
        int n = numerator * other.getDenominator() + denominator * other.getNumerator();
        int d = n == 0 ? 1 : denominator * other.getDenominator();

        return new Rational(n, d);
    }

    @Override
    public String toString() {
        return String.format("%d/%d", this.getNumerator(), this.getDenominator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !this.getClass().isAssignableFrom(obj.getClass())) {
            return false;
        }

        Rational other = (Rational) obj;
        return this.getNumerator() == other.getNumerator()
                && this.getDenominator() == other.getDenominator();
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.getNumerator();
        result = prime * result + this.getDenominator();

        return result;
    }

    public Rational subtract(Rational other) {
        int n = numerator * other.getDenominator() - denominator * other.getNumerator();
        int d = n == 0 ? 1 : denominator * other.getDenominator();

        return new Rational(n, d);
    }

    public Rational multiply(Rational rational) {
        return null;
    }

    public Rational divide(Rational rational) {
        return null;
    }

    public Rational abs() {
        return null;
    }

    public Rational pow(int i) {
        return null;
    }

    public double exp(double v) {
        return 0;
    }
}
