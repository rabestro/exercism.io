package parser;

import java.util.function.UnaryOperator;

public class MarkdownParser implements UnaryOperator<String> {
    private boolean activeList;
    private StringBuilder result;

    @Override
    public String apply(String text) {
        header();
        text.lines().forEach(this::parseLine);
        footer();
        return result.toString();
    }

    private void footer() {
        if (activeList) {
            result.append("</ul>");
        }
    }

    private void header() {
        activeList = false;
        result = new StringBuilder();
    }

    private void parseLine(String line) {
        var theLine = selectParser(line).apply(line);

        if (theLine.matches("(<li>).*") && !theLine.matches("(<h).*") && !theLine.matches("(<p>).*") && !activeList) {
            activeList = true;
            result.append("<ul>");
            result.append(theLine);
        } else if (!theLine.matches("(<li>).*") && activeList) {
            activeList = false;
            result.append("</ul>");
            result.append(theLine);
        } else {
            result.append(theLine);
        }
    }

    private boolean isHeader(String markdown) {
        return markdown.startsWith("#");
    }
    private boolean isListItem(String markdown) {
        return markdown.startsWith("*");
    }

    private UnaryOperator<String> selectParser(String markdown) {
        if (isHeader(markdown)) {
            return new HeaderParser();
        }
        if (isListItem(markdown)) {
            return new ListItemParser();
        }
        return new ParagraphParser();
    }
}
