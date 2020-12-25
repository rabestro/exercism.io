import java.util.Scanner;
import java.util.regex.Pattern;

class WordProblemSolver {
    private static final Pattern OPERATOR = Pattern.compile("plus|minus");

    public int solve(String input) {
        final var scanner = new Scanner(input.replaceFirst("What is (.+)\\?", "$1"))
                .useDelimiter("( by)? ");
        int result = scanner.nextInt();
        while (scanner.hasNext()) {
            final var operator = scanner.next();
            switch (operator) {
                case "plus":
                    result += scanner.nextInt();
                    break;
                case "minus":
                    result -= scanner.nextInt();
                    break;
                case "multiplied":
                    result *= scanner.nextInt();
                    break;
                case "divided":
                    result /= scanner.nextInt();
                    break;
                default:
                    throw new IllegalArgumentException("I'm sorry, I don't understand the question!");
            }
        }
        return result;
    }
}