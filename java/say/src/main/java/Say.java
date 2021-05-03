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
        final var units = List.of(" billion", " million", " thousand", "").iterator();
        return LongStream.of(1_000_000_000, 1_000_000, 1_000, 1)
                .mapToInt(i -> (int) (number % (i * 1000) / i))
                .mapToObj(i -> say(i, units.next()))
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.joining(" "));
    }

    private String say(int number, String unit) {
        if (number < 1) {
            return "";
        }
        if (number < 21) {
            return numbers[number] + unit;
        }
        if (number < 100) {
            final var units = number % 10;
            return numbers[18 + number / 10] + (units == 0 ? "" : "-" + numbers[units]) + unit;
        }
        final var units = say(number % 100);
        return say(number / 100, " hundred") + (units.isBlank() ? "" : " " + units) + unit;
    }

}
