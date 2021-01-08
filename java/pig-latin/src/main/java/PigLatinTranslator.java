import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class PigLatinTranslator {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");
    private static final Pattern BEGIN_WITH_VOWEL = Pattern.compile("^([aeoui]|xr|yt)");
    private static final Pattern RULES234 = Pattern.compile("^([^aeoui]?qu|[^aeoui][^aeouiy]*)(.*)");
    private static final String RULES234_REPLACE = "$2$1ay";

    public String translate(String sentence) {
        return WORDS_DELIMITER
                .splitAsStream(sentence)
                .map(this::toPigLatin)
                .collect(joining(" "));
    }
    private String toPigLatin(String word) {
        return BEGIN_WITH_VOWEL.matcher(word).find()
                ? word + "ay"
                : RULES234.matcher(word).replaceFirst(RULES234_REPLACE);
    }
}