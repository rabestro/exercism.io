import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

class SumOfMultiples {
    private final int sum;

    SumOfMultiples(int number, int[] set) {
        sum = range(1, number)
                .filter(n -> stream(set).anyMatch(m -> n % m == 0))
                .sum();
    }

    int getSum() {
        return sum;
    }

}
