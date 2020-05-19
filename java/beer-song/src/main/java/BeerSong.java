class BeerSong {

    public String sing(int count, int repeat) {
        final var song = new StringBuilder();
        while (repeat-- > 0) {
            if (count == 0) {
                song.append("No more bottles of beer on the wall, no more bottles of beer.\n")
                        .append("Go to the store and buy some more, ");
                count = 99;
            } else {
                song.append(bottle(count)).append(" of beer on the wall, ")
                        .append(bottle(count)).append(" of beer.\n")
                        .append("Take ").append(count == 1 ? "it" : "one")
                        .append(" down and pass it around, ");
                --count;
            }
            song.append(bottle(count)).append(" of beer on the wall.\n\n");
        }
        return song.toString();
    }

    public String singSong() {
        return sing(99, 100);
    }

    private String bottle(int count) {
        switch (count) {
            case 0:
                return "no more bottles";
            case 1:
                return "1 bottle";
            default:
                return count + " bottles";
        }
    }
}