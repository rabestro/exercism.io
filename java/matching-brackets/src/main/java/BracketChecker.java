final class BracketChecker {
    private final char[] chars;

    BracketChecker(String expression) {
        this.chars = expression.toCharArray();
    }

    public boolean areBracketsMatchedAndNestedCorrectly() {
        int stackI = 0;
        for (char c : chars) {
            if (c == '[') {
                chars[stackI++] = ']';
            } else if (c == '{') {
                chars[stackI++] = '}';
            } else if (c == '(') {
                chars[stackI++] = ')';
            } else if ((c == ')' || c == '}' || c == ']') && (stackI == 0 || c != chars[--stackI])) {
                return false;
            }
        }
        return stackI == 0;
    }

}
