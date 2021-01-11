import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {
    List<Integer> primeNumbers = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13));

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }
        if (nth > primeNumbers.size()) {
            calculatePrime(nth);
        }
        return primeNumbers.get(nth - 1);
    }

    void calculatePrime(int nth) {
        for (int i = primeNumbers.get(primeNumbers.size() - 1) + 1; nth > primeNumbers.size(); ++i) {
            if (isPrime(i)) {
                primeNumbers.add(i);
            }
        }
    }

    boolean isPrime(int number) {
        return primeNumbers.stream().allMatch(prime -> number % prime > 0);
    }
}
