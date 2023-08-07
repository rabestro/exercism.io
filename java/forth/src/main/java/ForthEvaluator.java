import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

class ForthEvaluator {
    private final Deque<Integer> stack = new ArrayDeque<>();

    public List<Integer> evaluateProgram(List<String> commands) {
        commands.forEach(this::evaluateLine);
        return stack.stream().toList();
    }

    private void evaluateLine(String line) {
        Arrays.asList(line.split(" ")).forEach(this::evaluateToken);
    }

    private void evaluateToken(String token) {
        if (isNumber(token)) {
            stack.add(Integer.parseInt(token));
        } else {
            evaluateOperation(token);
        }
    }

    private void evaluateOperation(String token) {
        switch (token) {
            case "+" -> {
                requireStackHasAtLeast(2, "Addition requires that the stack contain at least 2 values");
                stack.add(stack.poll() + stack.poll());
            }
            case "-" -> {
                requireStackHasAtLeast(2, "Subtraction requires that the stack contain at least 2 values");
                stack.add(stack.poll() - stack.poll());
            }
            case "*" -> {
                requireStackHasAtLeast(2, "Multiplication requires that the stack contain at least 2 values");
                stack.add(stack.poll() * stack.poll());
            }
            case "/" -> {
                requireStackHasAtLeast(2, "Division requires that the stack contain at least 2 values");
                int dividend = stack.poll();
                int divisor = stack.poll();
                if (divisor == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                stack.add(dividend / divisor);
            }
            case "dup" -> {
                requireStackHasAtLeast(1, "Duplicating requires that the stack contain at least 1 value");
                stack.add(stack.getLast());
            }
        }
    }

    private void requireStackHasAtLeast(int n, String message) {
        if (stack.size() < n) {
            throw new IllegalArgumentException(message);
        }
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
}
