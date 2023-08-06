package parser;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class LineParserFabric implements Function<String, Function<String, String>> {
    private static final Predicate<String> LIST_ITEM_MATCHER = Pattern.compile("(<li>).*").asMatchPredicate();
    private static final Predicate<String> HEADER_MATCHER = Pattern.compile("(<h).*").asMatchPredicate();
    private static final Predicate<String> PARAGRAPH_MATCHER = Pattern.compile("(<p>).*").asMatchPredicate();

    private final Parser headerParser = new HeaderParser();
    private final Parser listItemParser = new ListItemParser();
    private final Parser paragraphParser = new ParagraphParser();
    private final Parser textStyleParser = new TextStylesParser();

    @Override
    public Function<String, String> apply(String line) {
        final Parser lineParser;
        if (isHeader(line)) {
            lineParser = headerParser;
        } else if (isListItem(line)) {
            lineParser = listItemParser;
        } else {
            lineParser = paragraphParser;
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
