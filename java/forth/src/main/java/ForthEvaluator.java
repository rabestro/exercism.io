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
                ensureStackSize(2, "Addition requires that the stack contain at least 2 values");
                push(pop() + pop());
            },
            "-", () -> {
                ensureStackSize(2, "Subtraction requires that the stack contain at least 2 values");
                push(-pop() + pop());
            },
            "*", () -> {
                ensureStackSize(2, "Multiplication requires that the stack contain at least 2 values");
                push(pop() * pop());
            },
            "/", () -> {
                ensureStackSize(2, "Division requires that the stack contain at least 2 values");
                int divisor = pop();
                int dividend = pop();
                if (divisor == 0) {
                    throw new IllegalArgumentException("Division by 0 is not allowed");
                }
                push(dividend / divisor);
            },
            "dup", () -> {
                ensureStackSize(1, "Duplicating requires that the stack contain at least 1 value");
                push(peek());
            },
            "drop", () -> {
                ensureStackSize(1, "Dropping requires that the stack contain at least 1 value");
                pop();
            },
            "swap", () -> {
                ensureStackSize(2, "Swapping requires that the stack contain at least 2 values");
                int a = pop();
                int b = pop();
                push(a);
                push(b);
            },
            "over", () -> {
                ensureStackSize(2, "Overing requires that the stack contain at least 2 values");
                int a = pop();
                int b = peek();
                push(a);
                push(b);
            }
    );
    private final Map<String, Runnable> words;

    ForthEvaluator() {
        this.words = new HashMap<>(forthCore);
    }

    private void push(int value) {
        stack.add(value);
    }

    private int pop() {
        ensureStackSize(1, "Stack underflow");
        return stack.removeLast();
    }

    private int peek() {
        ensureStackSize(1, "Stack underflow");
        return stack.getLast();
    }

    public List<Integer> evaluateProgram(List<String> commands) {
        commands.forEach(this::evaluateLine);
        return List.copyOf(stack);
    }

    private void evaluateLine(String line) {
        var tokens = Arrays.asList(line.toLowerCase().split(" "));
        if (tokens.get(0).equals(":")) {
            evaluateMacro(tokens);
        } else {
            tokens.stream().map(this::compileToken).forEach(Runnable::run);
        }
    }

    private Runnable compileToken(String token) {
        if (isNumber(token)) {
            return () -> stack.add(Integer.parseInt(token));
        } else {
            return words.getOrDefault(token, () -> {
                throw new IllegalArgumentException("No definition available for operator \"" + token + "\"");
            });
        }
    }

    private void evaluateMacro(List<String> tokens) {
        var macroName = tokens.get(1);
        if (isNumber(macroName)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }
        var macroBody = tokens.subList(2, tokens.size() - 1).stream()
                .map(this::compileToken)
                .toList();

        words.put(macroName, () -> macroBody.forEach(Runnable::run));
    }

    private void ensureStackSize(int requiredStackSize, String errorMessage) {
        if (stack.size() < requiredStackSize) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
}
