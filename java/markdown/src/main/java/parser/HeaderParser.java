package parser;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public record HeaderParser(
        ToIntFunction<String> leadingHashesCounter,
        IntFunction<UnaryOperator<String>> headerParserBuilder
) implements Parser {

    HeaderParser() {
        this(new LeadingHashesCounter(), new HeaderParserBuilder());
    }


    @Override
    public String apply(String text) {
        var headerLevel = leadingHashesCounter.applyAsInt(text);
        var headerParser = headerParserBuilder.apply(headerLevel);
        return headerParser.apply(text);
    }
}
