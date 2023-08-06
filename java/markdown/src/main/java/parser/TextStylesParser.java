package parser;

import java.util.List;
import java.util.function.Function;

public record TextStylesParser(List<Function<String, String>> parsers) implements Parser {
    public TextStylesParser() {
        this(List.of(
                new ReplaceAllParser("__(.+)__", "<strong>$1</strong>"),
                new ReplaceAllParser("_(.+)_", "<em>$1</em>")));
    }

    @Override
    public String apply(String text) {
        return parsers().stream()
                .reduce(Function.identity(), Function::andThen)
                .apply(text);
    }
}
