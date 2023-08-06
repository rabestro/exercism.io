package parser;

import java.util.function.ToIntFunction;

public final class LeadingHashesCounter implements ToIntFunction<String> {

    @Override
    public int applyAsInt(String text) {
        return text.indexOf(' ');
    }
}
