import java.util.stream.Stream;

class ResistorColorDuo {
    enum Colors {BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE}

    int value(String[] colors) {
        return Stream.of(colors)
                .limit(2)
                .map(String::toUpperCase)
                .map(Colors::valueOf)
                .map(Colors::ordinal)
                .reduce((a, b) -> a * 10 + b)
                .orElse(0);
    }
}
