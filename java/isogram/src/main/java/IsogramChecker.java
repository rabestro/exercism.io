public class IsogramChecker {

    boolean isIsogram(String phrase) {
        return !phrase.matches("(?i).*(\\p{L}).*\\1.*");
    }

}
