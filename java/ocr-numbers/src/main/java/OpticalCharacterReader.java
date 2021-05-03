import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

class OpticalCharacterReader {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 4;

    private static final Map<String, String> DIGITS = Map.of(
            " _ | ||_|   ", "0", "     |  |   ", "1", " _  _||_    ", "2",
            " _  _| _|   ", "3", "   |_|  |   ", "4", " _ |_  _|   ", "5",
            " _ |_ |_|   ", "6", " _   |  |   ", "7",
            " _ |_||_|   ", "8", " _ |_| _|   ", "9"
    );

    public String parse(List<String> asList) {
        if (asList.size() % HEIGHT != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (asList.get(0).length() % WIDTH != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        final int cols = asList.get(0).length() / WIDTH;
        final int rows = asList.size() / HEIGHT;

        BiFunction<Integer, Integer, String> getSymbol = (row, col) ->
                range(HEIGHT * row, HEIGHT + HEIGHT * row)
                        .mapToObj(i -> asList.get(i).substring(WIDTH * col, WIDTH + col * WIDTH))
                        .collect(Collectors.joining());

        IntFunction<String> getLine = row -> range(0, cols)
                .mapToObj(col -> getSymbol.apply(row, col))
                .map(symbol -> DIGITS.getOrDefault(symbol, "?"))
                .collect(Collectors.joining());

        return range(0, rows).mapToObj(getLine).collect(Collectors.joining(","));
    }
}