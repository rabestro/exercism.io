class Bob {

    public String hey(String phrase) {
        if (phrase.matches("\\s*")) {
            return "Fine. Be that way!";
        }
        if (phrase.matches("([A-Z]|[^a-z])+\\?")) {
            return "Calm down, I know what I'm doing!";
        }
        if (phrase.matches("[^a-z]+")) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}