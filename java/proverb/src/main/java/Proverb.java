class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        return lastSentence();
    }

    private String lastSentence() {
        if (words.length == 0) {
            return "";
        }
        return "And all for the want of a " + words[0] + ".";
    }
}
