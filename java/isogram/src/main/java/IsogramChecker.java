import java.util.regex.Pattern;

class IsogramChecker {
    private static final Pattern IS_REPEATING_LETTER
            = Pattern.compile("(\\pL).*\\1", Pattern.CASE_INSENSITIVE);

    boolean isIsogram(String phrase) {
        return !IS_REPEATING_LETTER.matcher(phrase).find();
    }

}
