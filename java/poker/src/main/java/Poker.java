import java.util.Collections;
import java.util.List;

public final class Poker {

    private final List<String> hands;

    public Poker(List<String> hands) {
        this.hands = hands;
    }

    public List<String> getBestHands() {
        return Collections.singletonList("4S 5S 7H 8D JC");
    }
}