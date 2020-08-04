class LuhnValidator {

    boolean isValid(String candidate) {
        final var number = candidate.replaceAll(" ", "");
        if (!number.matches("[0-9]{2,}")) {
            return false;
        }
        var sum = 0;
        var isEven = number.length() % 2 == 0;
        for (var symbol : number.toCharArray()) {
            var digit = Character.getNumericValue(symbol);
            if (isEven) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9;
                }
            }
            sum += digit;
            isEven = !isEven;
        }
        return sum % 10 == 0;
    }

}
