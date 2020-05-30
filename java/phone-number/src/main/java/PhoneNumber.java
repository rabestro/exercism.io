class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number.replaceAll("[-+.() ]", "");
        if (this.number.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
    }

    public String getNumber() {
        return number;
    }
}
