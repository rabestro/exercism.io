import java.util.regex.Pattern;

class IsogramChecker {
    private static final Pattern REPEATING_LETTER =
            Pattern.compile("(\\pL).*\\1", Pattern.CASE_INSENSITIVE);

    boolean isIsogram(String phrase) {
        return !REPEATING_LETTER.matcher(phrase).find();
    }

}
