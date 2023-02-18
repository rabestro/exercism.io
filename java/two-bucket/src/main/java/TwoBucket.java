import java.util.HashSet;
import java.util.Set;

class TwoBucket {
    private static final String[] NAMES = {"one", "two"};
    private final Set<String> history = new HashSet<>();
    private final int[] cap;
    private final int[] volume = {0, 0};
    private final int source;
    private final int target;
    private final int goal;

    private int moves;

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        cap = new int[]{bucketOneCap, bucketTwoCap};
        source = NAMES[0].equals(startBucket) ? 0 : 1;
        target = 1 - source;
        goal = desiredLiters;
        calculateMoves();
    }

    int getTotalMoves() {
        return moves;
    }

    String getFinalBucket() {
        return NAMES[volume[source] == goal ? source : target];
    }

    int getOtherBucket() {
        return volume[volume[source] == goal ? target : source];
    }

    private void calculateMoves() {
        do {
            processStep();
            recordStep();
        } while (!isGoalAchieved());
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
        var state = volume[source] + "," + volume[target];
        if (history.contains(state)) {
            throw new IllegalArgumentException("the goal is not reachable");
        }
        history.add(state);
        ++moves;
    }

    private boolean isGoalAchieved() {
        return volume[source] == goal || volume[target] == goal;
    }
}
