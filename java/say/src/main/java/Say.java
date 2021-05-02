import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Say {
    private static final String[] numbers = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",
            "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
    };

    public String say(long number) {
        if (number < 0 || number > 999_999_999_999L) {
            throw new IllegalArgumentException();
        }
        if (number == 0) {
            return numbers[0];
        }
        final var units = List.of(" billion", " million", " thousand", " hundred", "").iterator();

        return LongStream.of(number / 1_000_000_000, number % 1_000_000_000 / 1_000_000,
                number % 1_000_000 / 1_000, number % 1_000 / 100, number % 100)
                .mapToObj(i -> say((int) i, units.next()))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.joining(" "));

    }

    private String say(int number, String unit) {
        return number > 20 ? numbers[18 + number / 10] + "-" + numbers[number % 10] + unit :
                number > 0 ? numbers[number] + unit : "";
    }

}
