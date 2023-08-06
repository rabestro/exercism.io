import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

record StyleParser(Pattern pattern, String template) implements UnaryOperator<String> {
    StyleParser(String pattern, String template) {
        this(Pattern.compile(pattern), template);
    }

    @Override
    public String apply(String text) {
        return pattern.matcher(text).replaceAll(template);
    }
}
