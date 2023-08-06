package parser;

import java.util.regex.Pattern;

public record ReplaceAllParser(Pattern pattern, String template) implements Parser {
    ReplaceAllParser(String pattern, String template) {
        this(Pattern.compile(pattern), template);
    }

    @Override
    public String apply(String text) {
        return pattern.matcher(text).replaceAll(template);
    }
}
