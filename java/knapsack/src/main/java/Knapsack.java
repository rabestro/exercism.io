import java.util.List;

public class Knapsack {
    public int maximumValue(int maxWeight, List<Item> items) {
        return 0;
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