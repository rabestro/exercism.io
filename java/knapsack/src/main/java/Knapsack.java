import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.function.Predicate.not;
import static java.util.stream.Collectors.toUnmodifiableList;

public class Knapsack {
    public int maximumValue(int maxWeight, List<Item> items) {
        final var smallItems = items.stream()
                .filter(item -> item.getWeight() <= maxWeight)
                .collect(toUnmodifiableList());

        int maxValue = 0;
        for (final var item : smallItems) {
            final var otherItems = smallItems.stream()
                    .filter(not(item::equals))
                    .collect(toUnmodifiableList());
            final var restWeight = maxWeight - item.getWeight();

            var value = item.getValue();
            if (restWeight > 0 ) {
                value += maximumValue(restWeight, otherItems);
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
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