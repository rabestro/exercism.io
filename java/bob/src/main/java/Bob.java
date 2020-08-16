class Bob {

    public String hey(String phrase) {
        if (phrase.matches("\\s*")) {
            return "Fine. Be that way!";
        }
        return "";
    }
}