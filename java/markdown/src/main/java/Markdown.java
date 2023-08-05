import java.util.Optional;
import java.util.stream.Stream;

class Markdown {
    private static final StyleParser BOLD_PARSER = new StyleParser("__(.+)__", "<strong>$1</strong>");

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
                theLine = parseParagraph(line);
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
        var count = (int)markdown.chars().takeWhile(ch -> ch == '#').count();

        if (count == 0) {
            return null;
        }

        var content = markdown.substring(count).trim();

        return String.format("<h%d>%s</h%d>", count, content, count);
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            var skipAsterisk = markdown.substring(2);
            var listItemString = parseSomeSymbols(skipAsterisk);
            return "<li>" + listItemString + "</li>";
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {
        return new TextStylesParser().apply(markdown);
    }
}
