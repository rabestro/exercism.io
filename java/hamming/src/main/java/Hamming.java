import static java.util.stream.IntStream.range;

public class Hamming {
    private final char[] leftStrand;
    private final char[] rightStrand;

    public Hamming(String leftStrand, String rightStrand) {
        if (leftStrand.length() == rightStrand.length()) {
            this.leftStrand = leftStrand.toCharArray();
            this.rightStrand = rightStrand.toCharArray();
        } else if (leftStrand.isEmpty()) {
            throw new IllegalArgumentException("left strand must not be empty.");
        } else if (rightStrand.isEmpty()) {
            throw new IllegalArgumentException("right strand must not be empty.");
        } else {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }

    public int getHammingDistance() {
        return (int) range(0, leftStrand.length).filter(i -> leftStrand[i] != rightStrand[i]).count();
    }
}
