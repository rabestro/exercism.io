import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class WordSearcher {
    Map<String, Optional<WordLocation>> search(final Set<String> words, final char[][] grid) {
        var square = new Square(grid);
        return words.stream()
                .collect(Collectors.toUnmodifiableMap(Function.identity(), square::wordLocation));
    }
}
