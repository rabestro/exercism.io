package forth.word;

import forth.ForthStack;

public class Dropping implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(1, "Dropping requires that the stack contain at least 1 value");
        stack.pop();
    }
}