package parser;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class MarkdownParser implements UnaryOperator<String> {
    private static final Predicate<String> LIST_ITEM_MATCHER = Pattern.compile("(<li>).*").asMatchPredicate();
    private static final Predicate<String> HEADER_MATCHER = Pattern.compile("(<h).*").asMatchPredicate();
    private static final Predicate<String> PARAGRAPH_MATCHER = Pattern.compile("(<p>).*").asMatchPredicate();

    private final UnaryOperator<String> headerParser = new HeaderParser();
    private final UnaryOperator<String> listItemParser = new ListItemParser();
    private final UnaryOperator<String> paragraphParser = new ParagraphParser();
    private final UnaryOperator<String> textStyleParser = new TextStylesParser();

    private boolean activeList;
    private StringBuilder result;

    @Override
    public String apply(String text) {
        initParseProcess();
        text.lines().forEach(this::parseLine);
        endParseProcess();
        return result.toString();
    }

    private void endParseProcess() {
        if (activeList) {
            result.append("</ul>");
        }
    }

    private void initParseProcess() {
        activeList = false;
        result = new StringBuilder();
    }

    private void parseLine(String line) {
        var parsedLine = selectParser(line).andThen(textStyleParser).apply(line);
        appendLine(parsedLine);
    }

    private boolean shouldEndList(String line) {
        return !LIST_ITEM_MATCHER.test(line) && activeList;
    }

    private boolean shouldStartList(String line) {
        return LIST_ITEM_MATCHER.test(line) && !HEADER_MATCHER.test(line) && !PARAGRAPH_MATCHER.test(line) && !activeList;
    }

    private boolean isHeader(String markdown) {
        return markdown.startsWith("#");
    }

    private boolean isListItem(String markdown) {
        return markdown.startsWith("*");
    }

    private UnaryOperator<String> selectParser(String markdown) {
        if (isHeader(markdown)) {
            return headerParser;
        }
        if (isListItem(markdown)) {
            return listItemParser;
        }
        return paragraphParser;
    }

    private void startList(String line) {
        activeList = true;
        result.append("<ul>").append(line);
    }

    private void endList(String line) {
        activeList = false;
        result.append("</ul>").append(line);
    }

    private void appendLine(String parsedLine) {
        if (shouldStartList(parsedLine)) {
            startList(parsedLine);
        } else if (shouldEndList(parsedLine)) {
            endList(parsedLine);
        } else {
            result.append(parsedLine);
        }
    }
}
