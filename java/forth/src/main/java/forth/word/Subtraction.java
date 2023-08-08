package forth.word;

import forth.ForthStack;

public class Subtraction implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(2, "Subtraction requires that the stack contain at least 2 values");
        stack.push(-stack.pop() + stack.pop());
    }
}
