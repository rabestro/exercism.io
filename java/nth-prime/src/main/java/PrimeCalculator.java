import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {
    List<Integer> primeNumbers = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13));

    int nth(int nth) {
        if (nth > primeNumbers.size()) {

        }
        return primeNumbers.get(nth - 1);
    }

}
