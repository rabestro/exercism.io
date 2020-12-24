import java.util.Map;
import java.util.regex.Pattern;

import static java.util.function.Predicate.not;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

public final class WordCount {
    private static final Pattern WORDS_DELIMITER =
            Pattern.compile("[^'a-z0-9]|(?<![a-z])'|'(?![a-z])");

    public Map<String, Integer> phrase(String text) {
        return WORDS_DELIMITER
                .splitAsStream(text.toLowerCase())
                .filter(not(String::isBlank))
                .collect(groupingBy(identity(), summingInt(e -> 1)));
    }
}