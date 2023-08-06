package parser;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

@FunctionalInterface
public interface Parser extends UnaryOperator<String> {
    Parser LIST_ITEM = of("^\\* (.+)$", "<li>$1</li>");
    Parser PARAGRAPH = of("^.*$", "<p>$0</p>");
    Parser BOLD_STYLE = of("__(.+)__", "<strong>$1</strong>");
    Parser ITALIC_STYLE = of("_(.+)_", "<em>$1</em>");

    static Parser of(String regexp, String template) {
        var pattern = Pattern.compile(regexp);
        return text -> pattern.matcher(text).replaceAll(template);
    }
}
