import java.util.Arrays;
import java.util.List;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toUnmodifiableList;

class Anagram {
    private final int[] source;
    private final String sourceWord;

    Anagram(final String word) {
        sourceWord = word;
        source = sourceWord.chars()
                .map(Character::toLowerCase)
                .sorted()
                .toArray();
    }

    List<String> match(final List<String> possibleAnagrams) {
        return possibleAnagrams
                .stream()
                .filter(not(sourceWord::equalsIgnoreCase))
                .filter(this::isAnagram)
                .collect(toUnmodifiableList());
    }

    private boolean isAnagram(final String otherWord) {
        final int[] other = otherWord.chars()
                .map(Character::toLowerCase)
                .sorted()
                .toArray();

        return Arrays.equals(source, other);
    }
}