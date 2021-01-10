import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class PigLatinTranslator {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");
    private static final Pattern PIG_LATIN_RULES = Pattern.compile(
            "^((?<vowel>[aeoui]|xr|yt)|(?<consonant>[^aeoui]?qu|[^aeoui][^aeouiy]*))(?<body>.*)");
    private static final String PIG_LATIN_REPLACE = "${vowel}${body}${consonant}ay";

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