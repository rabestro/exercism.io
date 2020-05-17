import java.util.Random;

class DnDCharacter {
    private static final Random random = new Random();

    private final int strength = this.ability();
    private final int dexterity = this.ability();
    private final int constitution = this.ability();
    private final int intelligence = this.ability();
    private final int wisdom = this.ability();
    private final int charisma = this.ability();
    private final int hitpoints = 10 + this.modifier(constitution);

    int ability() {
        return 3 + random.nextInt(6) + random.nextInt(6) + random.nextInt(6);
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

}
