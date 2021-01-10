import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class PigLatinTranslator {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");
    private static final Pattern PIG_LATIN_RULES = Pattern.compile(
            "^(([aeoui]|xr|yt)|([^aeoui]?qu|[^aeoui][^aeouiy]*)?)(.*)");
    private static final String PIG_LATIN_REPLACE = "$2$4$3ay";

    public String translate(String sentence) {
        return WORDS_DELIMITER
                .splitAsStream(sentence)
                .map(this::toPigLatin)
                .collect(joining(" "));
    }
    private String toPigLatin(String word) {
        return PIG_LATIN_RULES.matcher(word).replaceFirst(PIG_LATIN_REPLACE);
    }
}