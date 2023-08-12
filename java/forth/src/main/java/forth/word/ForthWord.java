package forth.word;


import java.util.Deque;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@FunctionalInterface
public interface ForthWord extends Consumer<Deque<Integer>> {
    Predicate<String> isNumber = Pattern.compile("\\d+").asMatchPredicate();

    static Map<String, ForthWord> builtInWords() {
        return Map.of(
                "+", new Addition(),
                "-", new Subtraction(),
                "*", new Multiplication(),
                "/", new Division(),
                "dup", new Duplication(),
                "drop", new Dropping(),
                "swap", new Swapping(),
                "over", new Overing()
        );
    }

    static void ensureSize(Deque<Integer> stack, int requiredSize, String errorMessage) {
        if (stack.size() < requiredSize) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    static ForthWord undefinedWord(String word) {
        return stack -> {
            throw new IllegalArgumentException("No definition available for operator \"" + word + "\"");
        };
    }

    static ForthWord number(String token) {
        return stack -> stack.push(Integer.parseInt(token));
    }
}
