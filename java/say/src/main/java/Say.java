public class Say {
    private static final String[] numbers = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "threaten", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
    };

    public String say(long number) {
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        return numbers[(int) number];
    }
}
