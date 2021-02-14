import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

public class WordSearcher {

    public Map<String, Optional<WordLocation>> search(Set<String> searchWords, char[][] chars) {
        final var rows = chars.length;
        final var cols = chars[0].length;
        final var result = new HashMap<String, Optional<WordLocation>>();

        for (final var word : searchWords) {
            final Predicate<Pair> isFoundLR = pair -> range(0, word.length()).allMatch(i -> chars[pair.getY()][pair.getX() + i] == word.charAt(i));
            result.put(word, range(0, rows).boxed()
                    .flatMap(y -> rangeClosed(0, cols - word.length()).mapToObj(x -> new Pair(x, y)))
                    .filter(isFoundLR)
                    .map(pair -> new Pair(pair.getX() + 1, pair.getY() + 1))
                    .map(pair -> new WordLocation(pair, new Pair(pair.getX() + word.length(), pair.getY())))
                    .findAny());
        }

        return result;
    }
}