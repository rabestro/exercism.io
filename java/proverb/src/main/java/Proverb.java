import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Proverb {
    private final String[] words;

    Proverb(String[] words) {
        this.words = words;
    }

    String recite() {
        return IntStream.range(0, words.length - 1)
                .mapToObj(this::cite)
                .collect(Collectors.joining())
                + lastSentence();
    }

    private String cite(int i) {
        return "For want of a " + words[i] + " the " + words[i + 1] + " was lost.\n";
    }

    private String lastSentence() {
        if (words.length == 0) {
            return "";
        }
        return "And all for the want of a " + words[0] + ".";
    }
}
