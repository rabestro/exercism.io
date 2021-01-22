public class Hand {
    private static final String FOUR_KIND = "(.?)(.)\\2{3}(.?)";
    private static final String FULL_HOUSE = "(.)\\1\\1(.)\\2|(.)\\3(.)\\4\\4";
    private static final String THREE = "(.*)(.)\\2\\2(.*)";
    private static final String TWO_PAIRS = "(.?)(.)\\2(.?)(.)\\4(.?)";
    private static final String ONE_PAIR = "(.*)(.)\\2(.*)";

    private final String representation;
    private final boolean isFlush;
    private final boolean isStright;
    private final String cards;
    private final String value;

    public Hand(String representation) {
        this.representation = representation;
        isFlush = representation.matches(".0?([SDHC])( .0?\\1){4}");
        cards = representation.replaceAll("[1SDHC ]", "")
                .codePoints()
                .map("AKQJ098765432"::indexOf)
                .map("ABCDEFGHIJKLM"::charAt)
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        isStright = "ABCDEFGHIJKLM AJKLM".contains(cards);

        if (isStright & isFlush) {
            value = "A" + cards.charAt(4);
        } else if (isFlush) {
            value = "D" + cards;
        } else if (isStright) {
            value = "E" + cards.charAt(4);
        } else if (cards.matches(FOUR_KIND)) {
            value = "B" + cards.replaceFirst(FOUR_KIND, "$2$1$3");
        } else if (cards.matches(FULL_HOUSE)) {
            value = "C" + cards.replaceFirst(FULL_HOUSE, "$1$4$2$3");
        } else if (cards.matches(THREE)) {
            value = "F" + cards.replaceFirst(THREE, "$2$1$3");
        } else if (cards.matches(TWO_PAIRS)) {
            value = "G" + cards.replaceFirst(TWO_PAIRS, "$2$4$1$3$5");
        } else if (cards.matches(ONE_PAIR)) {
            value = "H" + cards.replaceFirst(ONE_PAIR, "$2$1$3");
        } else {
            value = "I" + cards;
        }
    }

    public String getValue() {
        return value;
    }

    public String getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return representation;
    }
}
