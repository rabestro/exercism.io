import java.util.StringJoiner;

public class Say {
    private static final String[] numbers = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "threaten", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "thirty"
    };

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }
        if (number == 0) {
            return numbers[0];
        }
        return say((int) number);
    }

    private String say(int number) {
        var sj = new StringJoiner(" ");
        int hundred = number / 100;
        int rest = number % 100;
        if (hundred > 0) {
            sj.add(numbers[hundred]).add("hundred");
        }
        if (rest > 20) {
            sj.add(numbers[18 + rest / 10] + "-" + numbers[rest % 10]);
        } else if (rest > 0) {
            sj.add(numbers[rest]);
        }
        return sj.toString();
    }
}
