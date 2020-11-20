public final class PigLatinTranslator {

    public String translate(String word) {
        if (word.matches("([aeoui]|xr|yt).+")) {
            return word + "ay";
        }
        return word.replaceFirst("(qu|[^aeoui][^aeouiy]*?qu|[^aeoui][^aeouiy]*)(.*)", "$2$1ay");
    }
}