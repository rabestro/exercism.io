import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class OpticalCharacterReader {
    private static final Map<String, String> map = Map.of(
            " _ | ||_|   ", "0", "     |  |   ", "1"
    );

    public String parse(List<String> asList) {
        if (asList.size() % 4 != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (asList.get(0).length() % 3 != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        var symbol = IntStream.range(0, 4)
                .mapToObj(i -> asList.get(i).substring(0, 3))
                .collect(Collectors.joining());

        return map.getOrDefault(symbol, "?");
    }
}