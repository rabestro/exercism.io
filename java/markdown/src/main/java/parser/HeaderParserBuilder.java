package parser;

import java.util.function.IntFunction;
import java.util.function.UnaryOperator;

/**
 * A builder class for creating header parsers.
 * <p>
 * This class implements the {@code IntFunction} interface and provides a method {@code apply} to create a header parser
 * based on the specified header level.
 * The header parser returned by this builder replaces header text to HTML tags based on the header level.
 */
public final class HeaderParserBuilder implements IntFunction<UnaryOperator<String>> {
    private static boolean isInvalidHeaderLevel(int headerLevel) {
        return headerLevel < 1 || headerLevel > 6;
    }

    @Override
    public UnaryOperator<String> apply(int headerLevel) {
        if (isInvalidHeaderLevel(headerLevel)) {
            return text -> text;
        }
        var pattern = "^#{" + headerLevel + "} (.+)$";
        var template = "<h" + headerLevel + ">$1</h" + headerLevel + ">";
        return new ReplaceAllParser(pattern, template);
    }
}
