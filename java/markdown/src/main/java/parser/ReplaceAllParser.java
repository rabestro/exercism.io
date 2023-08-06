package parser;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public record ReplaceAllParser(Pattern pattern, String template) implements UnaryOperator<String> {
    ReplaceAllParser(String pattern, String template) {
        this(Pattern.compile(pattern), template);
    }

    @Override
    public String apply(String text) {
        return pattern.matcher(text).replaceAll(template);
    }
}
