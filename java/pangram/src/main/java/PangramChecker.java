public class PangramChecker {
    public boolean isPangram(String input) {
        return "abcdefghijklmnopqrstuvwxyz"
                .replaceAll("(?i)[ %s]".formatted(input), "")
                .isEmpty();
    }
}
