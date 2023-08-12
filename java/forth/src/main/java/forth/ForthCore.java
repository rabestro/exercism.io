package forth;


import forth.word.ForthWord;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static forth.word.ForthWord.isNumber;

public class ForthCore implements ForthEngine {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Map<String, Consumer<Deque<Integer>>> words;

    public ForthCore() {
        words = new HashMap<>(ForthWord.builtInWords());
    }


    @Override
    public void accept(String command) {
        var tokens = Arrays.asList(command.toLowerCase().split(" "));
        if (":".equals(tokens.get(0))) {
            defineWord(tokens);
        } else {
            compile(tokens).accept(stack);
        }
    }

    @Override
    public List<Integer> get() {
        var list = new ArrayList<Integer>();
        stack.descendingIterator().forEachRemaining(list::add);
        return list;
    }

    private void defineWord(List<String> tokens) {
        var word = validatedWord(tokens.get(1));
        var definition = tokens.subList(2, tokens.size() - 1);
        words.put(word, compile(definition));
    }

    private Consumer<Deque<Integer>> compile(List<String> tokens) {
        return tokens.stream().map(this::compile).reduce(Consumer::andThen).orElseThrow();
    }

    private Consumer<Deque<Integer>> compile(String token) {
        return isNumber.test(token) ? ForthWord.number(token) : words.getOrDefault(token, ForthWord.undefinedWord(token));
    }

    private String validatedWord(String word) {
        if (isNumber.test(word)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }
        return word;
    }

}
