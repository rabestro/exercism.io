import java.util.function.IntPredicate;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

class SumOfMultiples {
    private final int level;
    private final IntPredicate multiples;

    SumOfMultiples(int level, int[] baseValues) {
        this.level = level;
        this.multiples = number -> stream(baseValues)
                .filter(baseValue -> baseValue > 0)
                .anyMatch(baseValue -> number % baseValue == 0);
    }

    int getSum() {
        return range(1, level).filter(multiples).distinct().sum();
    }

}
