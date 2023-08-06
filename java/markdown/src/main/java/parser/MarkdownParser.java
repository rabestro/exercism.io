package parser;

import java.util.function.UnaryOperator;

public class MarkdownParser implements UnaryOperator<String> {
    private final UnaryOperator<String> headerParser = new HeaderParser();
    private final UnaryOperator<String> listItemParser = new ListItemParser();
    private final UnaryOperator<String> paragraphParser = new ParagraphParser();

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
        appendLine(selectParser(line).apply(line));
    }

    private boolean shouldEndList(String theLine) {
        return !theLine.matches("(<li>).*") && activeList;
    }

    private boolean shouldStartList(String theLine) {
        return theLine.matches("(<li>).*") && !theLine.matches("(<h).*") && !theLine.matches("(<p>).*") && !activeList;
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
