import forth.ForthShell;

import java.util.Arrays;
import java.util.List;

class ForthEvaluator {
    private final ForthShell forthEngine = new forth.ForthCore();

    public List<Integer> evaluateProgram(List<String> commands) {
        commands.forEach(this::evaluateLine);
        return forthEngine.getStackAsList();
    }

    private void evaluateLine(String line) {
        var tokens = Arrays.asList(line.toLowerCase().split(" "));
        if (":".equals(tokens.get(0))) {
            defineWord(tokens);
        } else {
            tokens.forEach(forthEngine);
        }
    }

    private void defineWord(List<String> tokens) {
        var word = tokens.get(1);
        var definition = tokens.subList(2, tokens.size() - 1);
        forthEngine.define(word, definition);
    }
}
