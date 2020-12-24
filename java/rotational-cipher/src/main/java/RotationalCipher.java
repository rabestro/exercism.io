import static java.lang.Character.isAlphabetic;
import static java.lang.Character.isUpperCase;

final class RotationalCipher {
    private static final int ALPHABET_LETTERS_COUNT = 26;

    private final int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

    String rotate(String data) {
        return data.chars()
                .map(this::encode)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private int encode(final int symbol) {
        if (isAlphabetic(symbol)) {
            final char firstLetter = isUpperCase(symbol) ? 'A' : 'a';
            return firstLetter + (symbol - firstLetter + shiftKey) % ALPHABET_LETTERS_COUNT;
        }
        return symbol;
    }
}
