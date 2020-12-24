import java.util.stream.IntStream;

import static java.util.stream.IntStream.rangeClosed;

final class NaturalNumber {
    private final int number;

    public NaturalNumber(final int number) {
        if (number < 1) {
            throw new IllegalArgumentException("You must supply a natural number (positive integer)");
        }
        this.number = number;
    }

    public IntStream divisors() {
        return rangeClosed(1, number / 2).filter(i -> number % i == 0);
    }

    public Classification getClassification() {
        final int aliquotSum = divisors().sum();
        if (aliquotSum < number) {
            return Classification.DEFICIENT;
        }
        if (aliquotSum > number) {
            return Classification.ABUNDANT;
        }
        return Classification.PERFECT;
    }
}
