import java.util.List;
import java.util.function.Predicate;
import java.util.stream.LongStream;

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
        final var iter = List.of("", " hundred").iterator();
        return LongStream
                .iterate(number, i -> i > 0, i -> i / 100)
                .mapToObj(i -> say((int) (i % 100), iter.next()))
                .filter(Predicate.not(String::isBlank))
                .reduce("", (a, b) -> b + (a.isBlank() ? "" : " " + a));
    }

    private String say(int number, String unit) {
        return number > 20 ? numbers[18 + number / 10] + "-" + numbers[number % 10] + unit :
                number > 0 ? numbers[number] + unit : "";
    }

}
