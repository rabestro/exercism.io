package forth.word;

import forth.ForthStack;

public class Duplication implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(1, "Duplicating requires that the stack contain at least 1 value");
        stack.push(stack.peek());
    }
}
