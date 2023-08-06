package parser;

import java.util.function.UnaryOperator;

public final class HeaderParser implements UnaryOperator<String> {

    @Override
    public String apply(String text) {
        var headerLevel = new LeadingHashesCounter().applyAsInt(text);
        var headerParser = new HeaderParserBuilder().apply(headerLevel);
        return headerParser.andThen(new TextStylesParser()).apply(text);
    }
}
