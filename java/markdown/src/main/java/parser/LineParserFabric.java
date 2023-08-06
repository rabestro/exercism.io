package parser;

import java.util.function.Function;

public class LineParserFabric implements Function<String, Function<String, String>> {
    private final Parser headerParser = new HeaderParser();

    @Override
    public Function<String, String> apply(String line) {
        final Parser lineParser;
        if (isHeader(line)) {
            lineParser = headerParser;
        } else if (isListItem(line)) {
            lineParser = Parser.LIST_ITEM;
        } else {
            lineParser = Parser.PARAGRAPH;
        }
        return lineParser.andThen(Parser.BOLD_STYLE).andThen(Parser.ITALIC_STYLE);
    }

    private boolean isHeader(String line) {
        return line.startsWith("#");
    }

    private boolean isListItem(String line) {
        return line.startsWith("*");
    }

}
