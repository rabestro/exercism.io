public class PangramChecker {
    private final static int ALPHABET = 'Z' - 'A' + 1;

    public boolean isPangram(String input) {
        return input.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .limit(ALPHABET)
                .count() == ALPHABET;
    }

}
