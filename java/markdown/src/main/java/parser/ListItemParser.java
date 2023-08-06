package parser;

import java.util.function.UnaryOperator;

public final class ListItemParser implements Parser {
    private static final UnaryOperator<String> LIST_PARSER = new ReplaceAllParser("^\\* (.+)$", "<li>$1</li>");

    @Override
    public String apply(String text) {
        return LIST_PARSER.apply(text);
    }
}
