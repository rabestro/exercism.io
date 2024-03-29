enum RomanNumeral {
    M(1000), CM(900), D(500), CD(400), C(100), XC(90),
    L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

    private final int value;

    RomanNumeral(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static String arabicToRoman(int number) {
        var sb = new StringBuilder();
        for (var romanNumber : RomanNumeral.values()) {
            while (romanNumber.getValue() <= number) {
                number -= romanNumber.getValue();
                sb.append(romanNumber);
            }
        }
        return sb.toString();
    }
}

class RomanNumerals {
    private final int value;

    public RomanNumerals(int value) {
        this.value = value;
    }

    public String getRomanNumeral() {
        return RomanNumeral.arabicToRoman(value);
    }
}
