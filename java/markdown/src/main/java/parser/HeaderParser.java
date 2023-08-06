package parser;

import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public record HeaderParser(
        ToIntFunction<String> leadingHashesCounter,
        IntFunction<UnaryOperator<String>> headerParserBuilder,
        UnaryOperator<String> textStylesParser) implements UnaryOperator<String> {

    HeaderParser() {
        this(new LeadingHashesCounter(), new HeaderParserBuilder(), new TextStylesParser());
    }


    @Override
    public String apply(String text) {
        var headerLevel = leadingHashesCounter.applyAsInt(text);
        var headerParser = headerParserBuilder.apply(headerLevel);
        return headerParser.andThen(textStylesParser).apply(text);
    }
}
