import java.util.ArrayList;
import java.util.List;

class PrimeCalculator {
    List<Integer> primes = new ArrayList<>(List.of(2, 3, 5, 7, 11, 13));

    int nth(int nth) {
        if (nth < 1) {
            throw new IllegalArgumentException();
        }
        if (nth > primes.size()) {
            calculatePrime(nth);
        }
        return primes.get(nth - 1);
    }

    void calculatePrime(int nth) {
        final int maxPrime = primes.get(primes.size() - 1);

        for (int i = maxPrime + 1; nth > primes.size(); ++i) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    boolean isPrime(int number) {
        return primes.stream().allMatch(prime -> number % prime > 0);
    }
}
