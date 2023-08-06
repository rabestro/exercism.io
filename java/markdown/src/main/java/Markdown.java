import parser.HeaderParser;
import parser.ListItemParser;
import parser.ParagraphParser;

class Markdown {
    String parse(String markdown) {
        var lines = markdown.split("\n");
        var result = new StringBuilder();
        var activeList = false;

        for (var line : lines) {

            var theLine = parseHeader(line);

            if (theLine == null) {
                theLine = parseListItem(line);
            }

            if (theLine == null) {
                theLine = new ParagraphParser().apply(line);
            }

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

    private String parseHeader(String markdown) {
        if (markdown.startsWith("#")) {
            return new HeaderParser().apply(markdown);
        }
        return null;
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            return new ListItemParser().apply(markdown);
        }
        return null;
    }

}
