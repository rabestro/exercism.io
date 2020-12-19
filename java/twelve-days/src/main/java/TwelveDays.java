import java.util.StringJoiner;

class TwelveDays {
    String verse(int verseNumber) {
        int i = verseNumber - 1;
        final var days = Days.values();
        final var song = new StringJoiner(" ",
                "On the " + days[i].name().toLowerCase() + " day of Christmas my true love gave to me: ",
                ".\n");

        for (; i >= 0; --i) {
            song.add(days[i].getGift());
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
        SECOND("two Turtle Doves, and"),
        THIRD("three French Hens,"),
        FOURTH("four Calling Birds,"),
        FIFTH("five Gold Rings,"),
        SIXTH("six Geese-a-Laying,"),
        SEVENTH("seven Swans-a-Swimming,"),
        EIGHTH("eight Maids-a-Milking,"),
        NINTH("nine Ladies Dancing,"),
        TENTH("ten Lords-a-Leaping,"),
        ELEVENTH("eleven Pipers Piping,"),
        TWELFTH("twelve Drummers Drumming,");

        private String gift;

        Days(String gift) {
            this.gift = gift;
        }

        String getGift() {
            return gift;
        }
    }
}

