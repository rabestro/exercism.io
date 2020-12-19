import java.util.StringJoiner;

class TwelveDays {
    String verse(int verseNumber) {
        int i = verseNumber - 1;
        final var days = Days.values();
        final var song = new StringJoiner(", and ",
                "On the " + days[i].name().toLowerCase() + " day of Christmas my true love gave to me: ",
                ".\n");

        while (i >= 0) {
            song.add(days[i--].getGift());
        }
        return song.toString();
    }

    String verses(int startVerse, int endVerse) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    String sing() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    enum Days {
        FIRST("a Partridge in a Pear Tree"),
        SECOND("two Turtle Doves");

        private String gift;

        Days(String gift) {
            this.gift = gift;
        }

        String getGift() {
            return gift;
        }
    }
}

