import java.util.stream.Stream;

class ResistorColor {
    enum Colors {BLACK, BROWN, RED, ORANGE, YELLOW, GREEN, BLUE, VIOLET, GREY, WHITE}

    int colorCode(String color) {
        return Colors.valueOf(color.toUpperCase()).ordinal();
    }

    String[] colors() {
        return Stream.of(Colors.values())
                .map(Enum::toString)
                .map(String::toLowerCase)
                .toArray(String[]::new);
    }
}
