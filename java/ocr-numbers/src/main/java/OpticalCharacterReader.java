import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toUnmodifiableMap;
import static java.util.stream.IntStream.range;

class OpticalCharacterReader {
    private static final int WIDTH = 3;
    private static final int HEIGHT = 4;
    private static final Map<String, String> DIGITS;

    static {
        List<String> in = List.of(
                " _     _  _     _  _  _  _  _ ",
                "| |  | _| _||_||_ |_   ||_||_|",
                "|_|  ||_  _|  | _||_|  ||_| _|",
                "                              "
        );
        Function<Integer, String> getDigit = i -> extractSymbol(in, 0, i);
        DIGITS = range(0, 10).boxed().collect(toUnmodifiableMap(getDigit, String::valueOf));
    }

    public String parse(List<String> asList) {
        if (asList.size() % HEIGHT != 0) {
            throw new IllegalArgumentException("Number of input rows must be a positive multiple of 4");
        }
        if (asList.get(0).length() % WIDTH != 0) {
            throw new IllegalArgumentException("Number of input columns must be a positive multiple of 3");
        }
        final int cols = asList.get(0).length() / WIDTH;
        final int rows = asList.size() / HEIGHT;

        IntFunction<String> getLine = row -> range(0, cols)
                .mapToObj(col -> extractSymbol(asList, row, col))
                .map(symbol -> DIGITS.getOrDefault(symbol, "?"))
                .collect(joining());

        return range(0, rows).mapToObj(getLine).collect(joining(","));
    }

    private static String extractSymbol(List<String> text, int row, int col) {
        return range(HEIGHT * row, HEIGHT + HEIGHT * row)
                .mapToObj(r -> text.get(r).substring(WIDTH * col, WIDTH + col * WIDTH))
                .collect(joining());
    }
}