import java.util.ArrayList;
import java.util.List;

class PrimeFactorsCalculator {
    public List<Long> calculatePrimeFactorsOf(long number) {
        var primeFactors = new ArrayList<Long>();
        long prime = 2;
        while (prime <= number) {
            if (number % prime == 0) {
                primeFactors.add(prime);
                number /= prime;
            } else {
                prime++;
            }
        }
        return primeFactors;
    }
}
