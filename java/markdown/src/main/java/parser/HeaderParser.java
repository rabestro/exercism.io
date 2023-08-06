package parser;

import java.util.Objects;
import java.util.function.IntFunction;

public record HeaderParser(IntFunction<Parser> headerParserBuilder) implements Parser {

    HeaderParser() {
        this(new HeaderParserBuilder());
    }

    @Override
    public String apply(String text) {
        Objects.requireNonNull(text);
        var headerLevel = text.indexOf(' ');
        var headerParser = headerParserBuilder.apply(headerLevel);
        return headerParser.apply(text);
    }


}
