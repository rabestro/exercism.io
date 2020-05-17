import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Anagram {
    private final char[] chars;
    private final String word;

    Anagram(final String word) {
        this.word = word;
        chars = this.word.toLowerCase().toCharArray();
        Arrays.sort(chars);
    }

    List<String> match(final List<String> possibleAnagrams) {
        return possibleAnagrams
                .stream()
                .filter(this::isAnagram)
                .collect(Collectors.toList());
    }

    private boolean isAnagram(final String word) {
        final char[] other = word.toLowerCase().toCharArray();
        Arrays.sort(other);
        return Arrays.equals(chars, other) && !this.word.equalsIgnoreCase(word);
    }
}