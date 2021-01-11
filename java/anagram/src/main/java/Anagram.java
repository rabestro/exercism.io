import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;

class Anagram {
    private final char[] wordChars;
    private final String word;

    Anagram(final String word) {
        this.word = word;
        wordChars = this.word.toLowerCase().toCharArray();
        Arrays.sort(wordChars);
    }

    List<String> match(final List<String> possibleAnagrams) {
        return possibleAnagrams
                .stream()
                .filter(not(word::equalsIgnoreCase))
                .filter(this::isAnagram)
                .collect(Collectors.toList());
    }

    private boolean isAnagram(final String otherWord) {
        final char[] otherChars = otherWord.toLowerCase().toCharArray();
        Arrays.sort(otherChars);
        return Arrays.equals(wordChars, otherChars);
    }
}