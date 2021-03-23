import java.util.List;

class ResistorColor {

    private static final String[] COLORS = new String[]{
            "black", "brown", "red", "orange", "yellow",
            "green", "blue", "violet", "grey", "white"};

    private static final List<String> COLORS_LIST = List.of(COLORS);

    int colorCode(String color) {
        return COLORS_LIST.indexOf(color);
    }

    String[] colors() {
        return COLORS;
    }
}
