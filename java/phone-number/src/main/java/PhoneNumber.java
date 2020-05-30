class PhoneNumber {
    private final String number;

    public PhoneNumber(String number) {
        var digits = number.replaceAll("[-+.() ]", "");
        if (digits.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (digits.length() == 11) {
            if (digits.startsWith("1")) {

            } else {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }
        this.number = digits;
    }

    public String getNumber() {
        return number;
    }
}
