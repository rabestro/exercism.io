import java.util.StringJoiner;
import java.util.regex.Pattern;

public final class PigLatinTranslator {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");

    public String translate(String sentence) {
        final var result = new StringJoiner(" ");

        WORDS_DELIMITER
                .splitAsStream(sentence)
                .map(this::toPigLatin)
                .forEach(result::add);

        return result.toString();
    }
    private String toPigLatin(String word) {
        return word.matches("([aeoui]|xr|yt).+")
                ? word + "ay"
                : word.replaceFirst("(qu|[^aeoui][^aeouiy]*?qu|[^aeoui][^aeouiy]*)(.*)", "$2$1ay");
    }
}