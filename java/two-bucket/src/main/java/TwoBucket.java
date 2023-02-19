import java.util.HashSet;
import java.util.List;
import java.util.Set;

class TwoBucket {
    private static final List<String> NAMES = List.of("one", "two");
    private final Set<State> history = new HashSet<>();
    private final int[] cap;
    private final int[] volume = {0, 0};
    private final int source;
    private final int target;
    private final int goal;

    private int moves;

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        cap = new int[]{bucketOneCap, bucketTwoCap};
        source = NAMES.indexOf(startBucket);
        target = 1 - source;
        goal = desiredLiters;
        calculateMoves();
    }

    int getTotalMoves() {
        return moves;
    }

    String getFinalBucket() {
        return NAMES.get(volume[source] == goal ? source : target);
    }

    int getOtherBucket() {
        return volume[volume[source] == goal ? target : source];
    }

    private void calculateMoves() {
        do {
            processStep();
            recordStep();
        } while (goalIsNotAchieved());
    }

    private void processStep() {
        if (volume[source] == 0) {
            volume[source] = cap[source];
        } else if (cap[target] == goal) {
            volume[target] = cap[target];
        } else if (volume[target] == cap[target]) {
            volume[target] = 0;
        } else {
            int pouring = Math.min(volume[source], cap[target] - volume[target]);
            volume[source] -= pouring;
            volume[target] += pouring;
        }
    }

    private void recordStep() {
        if (history.add(new State(volume[source], volume[target]))) {
            ++moves;
        } else {
            throw new IllegalArgumentException("the goal is not reachable");
        }
    }

    private boolean goalIsNotAchieved() {
        return volume[source] != goal && volume[target] != goal;
    }

    record State(int sourceVolume, int targetVolume) {
    }
}
