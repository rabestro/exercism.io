import parser.HeaderParser;
import parser.ListItemParser;
import parser.ParagraphParser;

import java.util.function.UnaryOperator;

class Markdown {
    String parse(String markdown) {
        var lines = markdown.split("\n");
        var result = new StringBuilder();
        var activeList = false;

        for (var line : lines) {
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

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
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
