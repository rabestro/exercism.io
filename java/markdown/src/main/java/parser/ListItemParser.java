package parser;

import java.util.function.UnaryOperator;

public final class ListItemParser implements UnaryOperator<String> {
    private static final UnaryOperator<String> TEXT_STYLES_PARSER = new TextStylesParser();
    private static final UnaryOperator<String> LIST_PARSER = new ReplaceAllParser("^\\* (.+)$", "<li>$1</li>");

    @Override
    public String apply(String text) {
        return LIST_PARSER.andThen(TEXT_STYLES_PARSER).apply(text);
    }
}
