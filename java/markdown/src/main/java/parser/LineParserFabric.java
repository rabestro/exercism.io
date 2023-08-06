package parser;

import java.util.function.Function;

public class LineParserFabric implements Function<String, Function<String, String>> {
    private static final Parser LIST_PARSER = new ReplaceAllParser("^\\* (.+)$", "<li>$1</li>");
    private static final Parser PARAGRAPH_PARSER = new ReplaceAllParser("^.*$", "<p>$0</p>");
    private static final Parser BOLD_STYLE_PARSER = new ReplaceAllParser("__(.+)__", "<strong>$1</strong>");
    private static final Parser ITALIC_STYLE_PARSER = new ReplaceAllParser("_(.+)_", "<em>$1</em>");

    private final Parser headerParser = new HeaderParser();

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
        return lineParser.andThen(BOLD_STYLE_PARSER).andThen(ITALIC_STYLE_PARSER);
    }

    private boolean isHeader(String line) {
        return line.startsWith("#");
    }

    private boolean isListItem(String line) {
        return line.startsWith("*");
    }

}
