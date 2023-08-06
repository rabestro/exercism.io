package parser;

import java.util.Objects;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;

public record HeaderParser(ToIntFunction<String> leadingHashesCounter, IntFunction<Parser> headerParserBuilder
) implements Parser {

    HeaderParser() {
        this(new LeadingHashesCounter(), new HeaderParserBuilder());
    }

    @Override
    public String apply(String text) {
        Objects.requireNonNull(text);
        var headerLevel = leadingHashesCounter.applyAsInt(text);
        var headerParser = headerParserBuilder.apply(headerLevel);
        return headerParser.apply(text);
    }
}
