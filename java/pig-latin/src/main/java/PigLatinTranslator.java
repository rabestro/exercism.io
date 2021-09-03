import java.util.regex.Pattern;

public final class PigLatinTranslator {
    private static final Pattern RULES = Pattern.compile(
            "(?<consonants>(?!xr|yt)y?((qu)|[\\w&&[^aeiouy]])*)?" +
                    "(?<base>\\w+)");
    private static final String TEMPLATE = "${base}${consonants}ay";

    public String translate(String sentence) {
        return RULES.matcher(sentence).replaceAll(TEMPLATE);
    }
}