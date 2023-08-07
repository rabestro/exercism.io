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

    }

    private boolean isNumber(String token) {
        return true;
    }
}
