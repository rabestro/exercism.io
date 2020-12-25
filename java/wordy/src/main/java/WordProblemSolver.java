import java.util.Scanner;
import java.util.regex.Pattern;

class WordProblemSolver {
    private static final Pattern MATH_QUESTION =
            Pattern.compile("What is [+-]?\\d+( (plus|minus|multiplied by|divided by) [+-]?\\d+)*[?]");

    public int solve(String input) {
        if (!MATH_QUESTION.matcher(input).matches()) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        final var scanner = new Scanner(input.replaceFirst("What is (.+)\\?", "$1"))
                .useDelimiter("( by)? ");

        int result = scanner.nextInt();
        while (scanner.hasNext()) {
            final var operator = scanner.next();
            switch (operator) {
                case "plus" -> result += scanner.nextInt();
                case "minus" -> result -= scanner.nextInt();
                case "multiplied" -> result *= scanner.nextInt();
                case "divided" -> result /= scanner.nextInt();
            }
        }
        return result;
    }
}