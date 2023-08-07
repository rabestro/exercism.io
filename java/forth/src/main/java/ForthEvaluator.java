import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class ForthEvaluator {
    private final Queue<Integer> stack = new ArrayDeque<>();

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
                requireStackHasAtLeast(2, "Addition");
                stack.add(stack.poll() + stack.poll());
            }
            case "-" -> {
                requireStackHasAtLeast(2, "Subtraction");
                stack.add(stack.poll() - stack.poll());
            }
            case "*" -> {
                requireStackHasAtLeast(2, "Multiplication");
                stack.add(stack.poll() * stack.poll());
            }
            case "/" -> {
                requireStackHasAtLeast(2, "Division");
                int dividend = stack.poll();
                int divisor = stack.poll();
                if (divisor == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                stack.add(dividend / divisor);
            }
        }
    }

    private void requireStackHasAtLeast(int n, String operation) {
        if (stack.size() < n) {
            throw new IllegalArgumentException(operation + " requires that the stack contain at least " + n + " values");
        }
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
}
