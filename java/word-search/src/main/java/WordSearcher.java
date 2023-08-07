import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

class WordSearcher {
    Map<String, Optional<WordLocation>> search(final Set<String> words, final char[][] grid) {
        return words.stream()
                .collect(toUnmodifiableMap(identity(), word -> new WordPosition(grid, word).get()));
    }
}
