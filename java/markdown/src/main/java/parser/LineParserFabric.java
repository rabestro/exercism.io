package parser;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class LineParserFabric implements Function<String, Function<String, String>> {
    private static final Parser LIST_PARSER = new ReplaceAllParser("^\\* (.+)$", "<li>$1</li>");
    private static final Parser PARAGRAPH_PARSER = new ReplaceAllParser("^.*$", "<p>$0</p>");

    private final Parser headerParser = new HeaderParser();
    private final Parser textStyleParser = new TextStylesParser();

    @Override
    public Function<String, String> apply(String line) {
        final Parser lineParser;
        if (isHeader(line)) {
            lineParser = headerParser;
        } else if (isListItem(line)) {
            lineParser = LIST_PARSER;
        } else {
            lineParser = PARAGRAPH_PARSER;
        }
        return lineParser.andThen(textStyleParser);
    }

    private boolean isHeader(String line) {
        return line.startsWith("#");
    }

    private boolean isListItem(String line) {
        return line.startsWith("*");
    }

}
