import java.util.Scanner;
import java.util.regex.Pattern;

class WordProblemSolver {
    private static final Pattern OPERATOR = Pattern.compile("plus|minus");

    public int solve(String input) {
        final var scanner = new Scanner(input.replaceFirst("What is (.+)\\?", "$1"));
        int result = scanner.nextInt();
        while (scanner.hasNext()) {
            final var operator = scanner.next(OPERATOR);
            final var operand = scanner.nextInt();
            switch (operator) {
                case "plus":
                    result += operand;
                    break;
                case "minus":
                    result -= operand;
                    break;
            }
        }
        return result;
    }
}