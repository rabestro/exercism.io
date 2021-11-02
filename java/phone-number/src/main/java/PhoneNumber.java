import java.util.Map;

class PhoneNumber {
    private static final Map<String, String> ERRORS = Map.of(
            ".*\\p{Alpha}.*", "letters not permitted",
            ".*[@:!].*", "punctuations not permitted",
            "\\d{12,}", "more than 11 digits",
            "\\d{0,9}", "incorrect number of digits",
            "[^1]\\d{10}", "11 digits must start with 1",
            "1?0\\d{9}", "area code cannot start with zero",
            "1?1\\d{9}", "area code cannot start with one",
            "1?\\d{3}0\\d{6}", "exchange code cannot start with zero",
            "1?\\d{3}1\\d{6}", "exchange code cannot start with one");

    private final String number;

    public PhoneNumber(String number) {
        var digits = number.replaceAll("[-+.() ]", "");

        for (var error : ERRORS.entrySet()) {
            if (digits.matches(error.getKey())) {
                throw new IllegalArgumentException(error.getValue());
            }
        }
        this.number = digits.substring(digits.length() - 10);
    }

    public String getNumber() {
        return number;
    }
}
