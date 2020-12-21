import java.util.HashSet;
import java.util.function.ToIntFunction;

import static java.util.Arrays.asList;

enum YachtCategory {

    YACHT(dice -> new HashSet(asList(dice)).size() == 1 ? 50 : 0),
    ONES(dice -> 0),
    TWOS(dice -> 0),
    THREES(dice -> 0),
    FOURS(dice -> 0),
    FIVES(dice -> 0),
    SIXES(dice -> 0),
    FULL_HOUSE(dice -> 0),
    FOUR_OF_A_KIND(dice -> 0),
    LITTLE_STRAIGHT(dice -> 0),
    BIG_STRAIGHT(dice -> 0),
    CHOICE(dice -> 0);

    private final ToIntFunction<int[]> scoreFormula;

    YachtCategory(ToIntFunction<int[]> scoreFormula) {
        this.scoreFormula = scoreFormula;
    }

    public int calculateScore(int[] dice) {
        return scoreFormula.applyAsInt(dice);
    }

}
