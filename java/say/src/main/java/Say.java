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
        int hundred = number / 100;
        int rest = number % 100;
        var result = hundred > 0 ? numbers[hundred] + " hundred " : "";
        if (rest > 20) {
            int dozens = rest / 10;
            int units = rest % 10;
            result += numbers[18 + dozens] + "-" + numbers[units];
        } else {
            result += rest > 0 ? numbers[rest] : "";
        }
        return result;
    }
}
