import java.util.function.ToIntFunction;

import static java.util.Arrays.stream;

enum YachtCategory {

    YACHT(dice -> stream(dice).distinct().count() == 1 ? 50 : 0),
    ONES(dice -> stream(dice).filter(i -> i == 1).sum()),
    TWOS(dice -> stream(dice).filter(i -> i == 2).sum()),
    THREES(dice -> stream(dice).filter(i -> i == 3).sum()),
    FOURS(dice -> stream(dice).filter(i -> i == 4).sum()),
    FIVES(dice -> stream(dice).filter(i -> i == 5).sum()),
    SIXES(dice -> stream(dice).filter(i -> i == 6).sum()),
    FULL_HOUSE(dice -> stream(dice).distinct().count() == 2 ? stream(dice).sum() : 0),
    FOUR_OF_A_KIND(dice -> stream(dice).distinct().count() == 2 ? 50 : 0),
    LITTLE_STRAIGHT(dice -> stream(dice).distinct().count() == 5 && stream(dice).max().getAsInt() == 5 ? 30 : 0),
    BIG_STRAIGHT(dice -> stream(dice).distinct().count() == 5 && stream(dice).min().getAsInt() == 2 ? 30 : 0),
    CHOICE(dice -> stream(dice).sum());

    private final ToIntFunction<int[]> scoreFormula;

    YachtCategory(ToIntFunction<int[]> scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public int calculateScore(int[] dice) {
        return scoreFormula.applyAsInt(dice);
    }

}
