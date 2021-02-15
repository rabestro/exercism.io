import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public final class PigLatinTranslator {
    private static final Pattern WORDS_DELIMITER = Pattern.compile("\\s+");
    private static final Pattern RULES = Pattern.compile(
            "((?<vowel>[aeoui]|xr|yt)|(?<consonant>[^aeoui]?qu|[^aeoui][^aeouiy]*))(?<body>.*)");
    private static final String TEMPLATE = "${vowel}${body}${consonant}ay";

    public String translate(String sentence) {
        return WORDS_DELIMITER
                .splitAsStream(sentence)
                .map(this::toPigLatin)
                .collect(joining(" "));
    }
    private String toPigLatin(String word) {
        return RULES.matcher(word).replaceFirst(TEMPLATE);
    }
}
