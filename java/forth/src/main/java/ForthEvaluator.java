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
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Addition requires that the stack contain at least 2 values");
                }
                stack.add(stack.poll() + stack.poll());
            }


        }
    }

    private boolean isNumber(String token) {
        return token.matches("\\d+");
    }
}
