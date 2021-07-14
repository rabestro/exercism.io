class Rational {
    public static final Rational ZERO = new Rational(0, 1);
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

    public Rational multiply(Rational other) {
        int n = numerator * other.getNumerator();
        if (n == 0) {
            return ZERO;
        }
        int d = denominator * other.getDenominator();
        return simplify(n, d);
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

    private Rational simplify(int a, int b) {
        int cd = gdc(a, b);
        return cd == 1 ? new Rational(a, b) : new Rational(a / cd, b / cd);
    }

    private int gdc(int n, int m) {
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        if (n == m) {
            return m;
        }
        final var isFirstEven = (n & 1) == 0;
        final var isSecondEven = (m & 1) == 0;

        if (isFirstEven && isSecondEven) {
            return gdc(n >> 1, m >> 1);
        }
        if (isFirstEven) {
            return gdc(n >> 1, m);
        }
        if (isSecondEven) {
            return gdc(n, m >> 1);
        }
        if (n > m) {
            return gdc((n - m) / 2, m);
        }
        return gdc((m - n) / 2, n);
    }
}
