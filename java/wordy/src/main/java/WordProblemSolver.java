import java.util.Scanner;
import java.util.regex.Pattern;

class WordProblemSolver {
    private static final Pattern MATH_QUESTION =
            Pattern.compile("What is [+-]?\\d+( (plus|minus|multiplied by|divided by) [+-]?\\d+)*[?]");

    public int solve(String input) {
        if (!MATH_QUESTION.matcher(input).matches()) {
            throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
        }
        var scanner = new Scanner(input.replaceFirst("What is (.+)\\?", "$1"))
                .useDelimiter("( by)? ");

        int result = scanner.nextInt();
        while (scanner.hasNext()) {
            var operation = scanner.next();
            var operand = scanner.nextInt();
            switch (operation) {
                case "plus" -> result += operand;
                case "minus" -> result -= operand;
                case "multiplied" -> result *= operand;
                case "divided" -> result /= operand;
            }
        }
        return result;
    }
}
