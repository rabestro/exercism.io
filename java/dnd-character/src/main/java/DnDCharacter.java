import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class DnDCharacter {
    private static final int ROLLING_SEQUENCE_SIZE = 4;

    private final int strength = this.ability();
    private final int dexterity = this.ability();
    private final int constitution = this.ability();
    private final int intelligence = this.ability();
    private final int wisdom = this.ability();
    private final int charisma = this.ability();
    private final int hitpoints = 10 + this.modifier(constitution);

    int ability() {
        return ThreadLocalRandom.current()
                .ints(ROLLING_SEQUENCE_SIZE, 1, 7)
                .sorted().skip(1).sum();
    }

    int modifier(int input) {
        return (int) Math.floor((input - 10) / 2.);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return hitpoints;
    }

    int ability(List<Integer> rolls) {
        return rolls.stream().sorted().mapToInt(Integer::intValue).skip(1).sum();
    }

    public List<Integer> rollDice() {
        return ThreadLocalRandom.current()
                .ints(ROLLING_SEQUENCE_SIZE, 1, 7)
                .boxed().toList();
    }
}
