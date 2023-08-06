package parser;

import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public final class HeaderParser implements UnaryOperator<String> {
    private static final UnaryOperator<String> TEXT_STYLES_PARSER = new TextStylesParser();
    private static final ToIntFunction<String> LEADING_HASHES_COUNTER = new LeadingHashesCounter();

    @Override
    public String apply(String text) {
        var headerLevel = LEADING_HASHES_COUNTER.applyAsInt(text);
        if (headerLevel == 0) {
            return text;
        }
        var headerParser = new StyleParser("^#{" + headerLevel + "} (.+)$", "<h" + headerLevel + ">$1</h" + headerLevel + ">");
        return headerParser.andThen(TEXT_STYLES_PARSER).apply(text);
    }
}
