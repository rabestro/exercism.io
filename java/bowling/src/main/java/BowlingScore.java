import java.util.ArrayList;
import java.util.List;

public final class BowlingScore {
    private static final int MAX_PINS = 10;
    private final List<Integer> rolls;

    public BowlingScore() {
        this.rolls = new ArrayList<>();
    }

    public boolean isGameOver() {
        return rolls.size() == 21;
    }
    
    class Frame {
        private final int firstRollIndex;

        Frame(int firstRollIndex) {
            this.firstRollIndex = firstRollIndex;
        }

        int firstRoll() {
            return rolls.get(firstRollIndex);
        }
        int secondRoll() {
            return rolls.get(firstRollIndex + 1);
        }
        int thirdRoll() {
            return rolls.get(firstRollIndex + 2);
        }

        int baseScore() {
            return firstRoll() + secondRoll();
        }

        boolean isStrike() {
            return firstRoll() == MAX_PINS;
        }

        boolean isSpare() {
            return !isStrike() && baseScore() == MAX_PINS;
        }

        int score() {
            if (isStrike() || isSpare()) {
                return baseScore() + thirdRoll();
            } else {
                return baseScore();
            }
        }
    }
}
