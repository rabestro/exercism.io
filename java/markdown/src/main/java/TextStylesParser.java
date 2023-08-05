import java.util.Optional;
import java.util.function.UnaryOperator;

public final class TextStylesParser implements UnaryOperator<String> {
    private static final StyleParser BOLD_PARSER = new StyleParser("__(.+)__", "<strong>$1</strong>");
    private static final StyleParser ITALIC_PARSER = new StyleParser("_(.+)_", "<em>$1</em>");

    @Override
    public String apply(String text) {
        return Optional.ofNullable(text)
                .map(BOLD_PARSER)
                .map(ITALIC_PARSER)
                .orElse(text);
    }
}
