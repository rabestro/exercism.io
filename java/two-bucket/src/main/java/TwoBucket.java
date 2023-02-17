import java.util.HashSet;
import java.util.Set;

class TwoBucket {
    Bucket source;
    Bucket target;
    int goal;
    int step;
    Set<String> history = new HashSet<>();

    TwoBucket(int bucketOneCap, int bucketTwoCap, int desiredLiters, String startBucket) {
        Bucket.one.cap = bucketOneCap;
        Bucket.two.cap = bucketTwoCap;
        Bucket.one.volume = Bucket.two.volume = 0;
        goal = desiredLiters;

        if (startBucket.equals(Bucket.one.name())) {
            source = Bucket.one;
            target = Bucket.two;
        } else {
            source = Bucket.two;
            target = Bucket.one;
        }
    }

    int getTotalMoves() {
        do {
            processStep();
            recordStep();
        } while (!isGoalArchived());
        return step;
    }

    private void processStep() {
        if (source.isEmpty()) {
            source.fill();
        } else if (target.cap == goal) {
            target.fill();
        } else if (target.isFull()) {
            target.empty();
        } else {
            int pouring = Math.min(source.volume, target.cap - target.volume);
            source.volume -= pouring;
            target.volume += pouring;
        }
    }

    private void recordStep() {
        var state = source.volume + "," + target.volume;
        if (history.contains(state)) {
            throw new IllegalArgumentException();
        }
        history.add(state);
        ++step;
    }

    private boolean isGoalArchived() {
        return source.volume == goal || target.volume == goal;
    }

    String getFinalBucket() {
        return source.volume == goal ? source.name() : target.name();
    }

    int getOtherBucket() {
        return source.volume == goal ? target.volume : source.volume;
    }
}
