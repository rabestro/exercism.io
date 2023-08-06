package parser;

import java.util.function.IntFunction;

public final class HeaderParserBuilder implements IntFunction<Parser> {
    private static boolean isInvalidHeaderLevel(int headerLevel) {
        return headerLevel < 1 || headerLevel > 6;
    }

    @Override
    public Parser apply(int headerLevel) {
        if (isInvalidHeaderLevel(headerLevel)) {
            return text -> text;
        }
        var pattern = "^#{" + headerLevel + "} (.+)$";
        var template = "<h" + headerLevel + ">$1</h" + headerLevel + ">";
        return Parser.of(pattern, template);
    }
}
