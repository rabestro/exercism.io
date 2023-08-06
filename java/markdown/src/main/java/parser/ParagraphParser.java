package parser;

import java.util.function.UnaryOperator;

public final class ParagraphParser implements UnaryOperator<String> {
    private static final UnaryOperator<String> TEXT_STYLES_PARSER = new TextStylesParser();
    private static final UnaryOperator<String> PARAGRAPH_PARSER = new ReplaceAllParser("^.*$", "<p>$0</p>");

    @Override
    public String apply(String text) {
        return PARAGRAPH_PARSER.andThen(TEXT_STYLES_PARSER).apply(text);
    }
}
