class Isogram {
    static boolean isIsogram(String phrase) {
        !phrase.matches(/.*(.).*\1.*/)
    }
}