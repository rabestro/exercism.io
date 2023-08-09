import java.util.StringJoiner;

class FoodChain {
    private static final String[] ANIMALS = {
            "fly",
            "spider",
            "bird",
            "cat",
            "dog",
            "goat",
            "cow",
            "horse"
    };
    private static final String[] VERSES = {
            "I don't know why she swallowed the fly. Perhaps she'll die.",
            "It wriggled and jiggled and tickled inside her.",
            "How absurd to swallow a bird!",
            "Imagine that, to swallow a cat!",
            "What a hog, to swallow a dog!",
            "Just opened her throat and swallowed a goat!",
            "I don't know how she swallowed a cow!",
            "She's dead, of course!"
    };

    public String verse(int verse) {
        var sb = new StringJoiner(System.lineSeparator());
        sb.add("I know an old lady who swallowed a " + ANIMALS[verse - 1] + ".");
        sb.add(VERSES[verse - 1]);
        return sb.toString();
    }

    public String verses(int startVerse, int endVerse) {
        return null;
    }
}
