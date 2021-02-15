import java.util.regex.Pattern;

class Acronym {
    private final String acronym;
    private static final Pattern PATTERN = Pattern.compile("\\b_?(\\w)[^-\\s]*[- ]*");
    private static final String TEMPLATE = "$1";

    Acronym(String phrase) {
        acronym = PATTERN
                .matcher(phrase)
                .replaceAll(TEMPLATE)
                .toUpperCase();
    }

    String get() {
        return acronym;
    }

}
