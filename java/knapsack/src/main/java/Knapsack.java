import java.util.List;
import java.util.stream.IntStream;

public class Knapsack {
    int maximumValue(int capacity, List<Item> items) {
        return IntStream.range(0, items.size()).map(i -> {
            final var weight = capacity - items.get(i).getWeight();
            final var value = items.get(i).getValue();
            return weight < 0 ? 0 : value + maximumValue(weight, items.subList(i + 1, items.size()));
        }).max().orElse(0);
    }
}

class Item {
    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }
}