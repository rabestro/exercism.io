import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toUnmodifiableList;

class Anagram {
    String subject

    def find(List<String> candidates) {
        sortedChars = toSortedChars(subject)

        return candidates.stream()
                .filter{ word -> !subject.equalsIgnoreCase(word) && isAnagram(sortedChars, word)}
                .toList()
    }

    private static boolean isAnagram(int[] sortedChars, String otherWord) {
        Arrays.equals(sortedChars, toSortedChars(otherWord))
    }

    private static int[] toSortedChars(String word) {
        word.toLowerCase().chars().sorted().toArray()
    }
}