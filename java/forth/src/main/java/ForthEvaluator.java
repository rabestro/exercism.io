import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ForthEvaluator {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Map<String, Runnable> forthCore = Map.of(
            "+", () -> {
                requireStackHasAtLeast(2, "Addition requires that the stack contain at least 2 values");
                stack.add(stack.removeLast() + stack.removeLast());
            },
            "-", () -> {
                requireStackHasAtLeast(2, "Subtraction requires that the stack contain at least 2 values");
                stack.add(-stack.removeLast() + stack.removeLast());
            },
            "*", () -> {
                requireStackHasAtLeast(2, "Multiplication requires that the stack contain at least 2 values");
                stack.add(stack.removeLast() * stack.removeLast());
            },
            "/", () -> {
                requireStackHasAtLeast(2, "Division requires that the stack contain at least 2 values");
                int divisor = stack.removeLast();
                int dividend = stack.removeLast();
                if (divisor == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                stack.add(dividend / divisor);
            },
            "dup", () -> {
                requireStackHasAtLeast(1, "Duplicating requires that the stack contain at least 1 value");
                stack.add(stack.peekLast());
            },
            "drop", () -> {
                requireStackHasAtLeast(1, "Dropping requires that the stack contain at least 1 value");
                stack.removeLast();
            },
            "swap", () -> {
                requireStackHasAtLeast(2, "Swapping requires that the stack contain at least 2 values");
                int a = stack.removeLast();
                int b = stack.removeLast();
                stack.add(a);
                stack.add(b);
            },
            "over", () -> {
                requireStackHasAtLeast(2, "Overing requires that the stack contain at least 2 values");
                int a = stack.removeLast();
                int b = stack.getLast();
                stack.add(a);
                stack.add(b);
            }
    );
    private final Map<String, Runnable> macros;

    ForthEvaluator() {
        this.macros = new HashMap<>(forthCore);
    }

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
        macros.getOrDefault(token, () -> {
            throw new IllegalArgumentException("Unknown operation");
        }).run();
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
