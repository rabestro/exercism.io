import java.util.ArrayList;
import java.util.List;

class BowlingGame {
    private static final int MAX_PINS = 10;
    private final List<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        if (pins > MAX_PINS) {
            throw new IllegalStateException("Pin count exceeds pins on the lane");
        }
        rolls.add(pins);
    }

    public int score() {
        var sum = 0;
        var i = 0;
        for (var frame = 0; frame < MAX_PINS; frame++) {
            int first = rolls.get(i);
            i++;
            sum += first;
            if (first == MAX_PINS) {
                sum += rolls.get(i) + rolls.get(i + 1);
                continue;
            }
            int second = rolls.get(i);
            if ((first + second) > MAX_PINS) {
                throw new IllegalStateException("Pin count exceeds pins on the lane");
            }
            sum += second;
            ++i;
            if (first + second == MAX_PINS) {
                sum += rolls.get(i);
            }
        }
        return sum;
    }
}
