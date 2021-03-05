class Bob {
    static response(phrase) {
        if (phrase.matches("\\s*")) {
            return "Fine. Be that way!";
        }
        if (phrase.matches("[^a-z]*[A-Z][^a-z]*\\?")) {
            return "Calm down, I know what I'm doing!";
        }
        if (phrase.matches(".*\\?\\s*")) {
            return "Sure.";
        }
        if (phrase.matches("[^a-z]*[A-Z][^a-z]*")) {
            return "Whoa, chill out!";
        }
        return "Whatever.";
    }
}