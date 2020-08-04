class LuhnValidator {

    boolean isValid(String candidate) {
        final var number = candidate.replaceAll(" ", "");
        return number.matches("[0-9]{3,}");
    }

}
