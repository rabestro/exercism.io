import java.util.List;
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
        final var iter = List.of("", " hundred", " thousand", " million").iterator();

        var sj = new StringJoiner(" ");

        int i = (int) (number / 1000000);
        var out = say(i, " million");
        if (!out.isBlank()) sj.add(out);
        number %= 1000000;

        i = (int) (number / 1000);
        out = say(i, " thousand");
        if (!out.isBlank()) sj.add(out);
        number %= 1000;

        i = (int) (number / 100);
        out = say(i, " hundred");
        if (!out.isBlank()) sj.add(out);
        number %= 100;

        i = (int) number;
        out = say(i, "");
        if (!out.isBlank()) sj.add(out);

        return sj.toString();
    }

    private String say(int number, String unit) {
        return number > 20 ? numbers[18 + number / 10] + "-" + numbers[number % 10] + unit :
                number > 0 ? numbers[number] + unit : "";
    }

}
