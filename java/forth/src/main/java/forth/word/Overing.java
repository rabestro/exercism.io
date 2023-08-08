package forth.word;

import forth.ForthStack;

public class Overing implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(2, "Overing requires that the stack contain at least 2 values");
        int a = stack.pop();
        int b = stack.peek();
        stack.push(a);
        stack.push(b);
    }
}
