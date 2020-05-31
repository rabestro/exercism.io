class IsbnVerifier {

    boolean isValid(String stringToVerify) {
        var digits = stringToVerify.replace("-", "");
        if (!digits.matches("\\d{9}[X\\d]")) {
            return false;
        }
        return true;
    }

}
