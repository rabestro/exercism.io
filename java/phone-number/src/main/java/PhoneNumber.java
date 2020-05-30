class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) {
        if (number.matches(".*\\p{Alpha}.*")) {
            throw new IllegalArgumentException("letters not permitted");
        }
        if (number.matches(".*[@:!].*")) {
            throw new IllegalArgumentException("punctuations not permitted");
        }

        var digits = number.replaceAll("[-+.() ]", "");

        if (digits.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (digits.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (digits.length() == 11) {
            if (digits.startsWith("1")) {
                digits = digits.substring(1);
            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }
        if (digits.startsWith("0")) {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        this.number = digits;
    }

    public String getNumber() {
        return number;
    }
}
