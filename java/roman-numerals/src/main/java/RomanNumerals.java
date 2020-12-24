enum RomanNumerals {
    M(1000), CM(900), D(500), CD(400), C(100), XC(90),
    L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private final int value;

    RomanNumerals(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String arabicToRoman(int number) {
        final var sb = new StringBuilder();
        for (var romanNumber : RomanNumerals.values()) {
            while (romanNumber.getValue() <= number) {
                number -= romanNumber.getValue();
                sb.append(romanNumber.toString());
            }
        }
        return sb.toString();
    }
}

class RomanNumeral {
    final private int value;

    public RomanNumeral(int value) {
        this.value = value;
    }

    public String getRomanNumeral() {
        return RomanNumerals.arabicToRoman(value);
    }
}