package forth;

public interface ForthStack {
    void push(int value);

    int pop();

    int peek();

    void ensureSize(int requiredSize, String errorMessage);
}
