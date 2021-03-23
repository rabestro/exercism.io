import java.util.List;

class ResistorColor {
    private static final List<String> colors = List.of(
            "black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white");

    int colorCode(String color) {
        return colors.indexOf(color);
    }

    String[] colors() {
        return colors.toArray(String[]::new);
    }
}
