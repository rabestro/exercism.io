import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public final class TextStylesParser implements UnaryOperator<String> {
    private static final List<StyleParser> PARSERS = List.of(
            new StyleParser("__(.+)__", "<strong>$1</strong>"),
            new StyleParser("_(.+)_", "<em>$1</em>")
    );

    @Override
    public String apply(String text) {
        var result = Optional.ofNullable(text);
        for (var parser : PARSERS) {
            result = result.map(parser);
        }
        return result.orElse(text);
    }
}
