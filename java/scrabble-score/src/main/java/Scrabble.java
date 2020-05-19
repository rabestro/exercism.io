class Scrabble {
    private static final int[] LETTER_VALUES =
            {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    //       A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P   Q  R  S  T  U  V  W  X  Y   Z

    private final String word;

    Scrabble(String word) {
        this.word = word.toUpperCase();
    }

    int getScore() {
        return word.chars().map(i -> LETTER_VALUES[i - 'A']).sum();
    }

}
