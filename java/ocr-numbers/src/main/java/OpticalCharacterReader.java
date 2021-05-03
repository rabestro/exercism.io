import java.util.List;
import java.util.Map;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class OpticalCharacterReader {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 4;

    private static final Map<String, String> map = Map.of(
            " _ | ||_|   ", "0", "     |  |   ", "1", " _  _||_    ", "2",
            " _  _| _|   ", "3", "   |_|  |   ", "4", " _ |_  _|   ", "5"
    );

    public String parse(List<String> asList) {
        if (asList.size() % HEIGHT != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (asList.get(0).length() % WIDTH != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        int cols = asList.get(0).length() / WIDTH;

        IntFunction<String> getSymbol = col -> range(0, HEIGHT)
                .mapToObj(i -> asList.get(i).substring(WIDTH * col, WIDTH + col * WIDTH))
                .collect(Collectors.joining());

        return range(0, cols)
                .mapToObj(getSymbol)
                .map(symbol -> map.getOrDefault(symbol, "?"))
                .collect(Collectors.joining());
    }
}