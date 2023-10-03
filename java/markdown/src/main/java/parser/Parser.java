package parser;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

/**
 * An interface representing a parser for transforming text.
 *
 * <p>
 * This interface extends the {@link UnaryOperator UnaryOperator} functional interface,
 * and provides methods for parsing and transforming the input text.
 * </p>
 *
 * <p>
 * Implementations of this interface can be used to define various parsing rules for different elements of the text,
 * and can be composed together to create more complex parsers.
 * </p>
 *
 * <p>
 * The {@code Parser} interface provides a few predefined parsers for common parsing patterns, such as headers,
 * list items, paragraphs, bold styling, and italic styling.
 * Additionally, it includes a static factory method ({@link #of(String, String)}) for creating custom parsers.
 * </p>
 *
 * <p>
 * Note: The {@code Parser} interface is a functional interface, which means it can be used as the type of a lambda expression
 * or method reference.
 * </p>
 *
 * @see UnaryOperator
 */
@FunctionalInterface
public interface Parser extends UnaryOperator<String> {
    Parser HEADER = new HeaderParser();
    Parser LIST_ITEM = of("^\\* (.+)$", "<li>$1</li>");
    Parser PARAGRAPH = of("^.*$", "<p>$0</p>");
    Parser BOLD_STYLE = of("__(.+)__", "<strong>$1</strong>");
    Parser ITALIC_STYLE = of("_(.+)_", "<em>$1</em>");

    static Parser of(String regexp, String template) {
        var pattern = Pattern.compile(regexp);
        return text -> pattern.matcher(text).replaceAll(template);
    }
}
