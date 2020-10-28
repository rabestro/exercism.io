import java.util.HashSet;
import java.util.Random;
import java.util.Set;

final class Robot {
    private static final Random random = new Random();
    private static final int LETTERS = 1 + 'Z' - 'A';
    private static final Set<String> names = new HashSet<>();

    private String name = generateName();

    public String getName() {
        return name;
    }

    public void reset() {
        var oldName = name;
        name = generateName();
        names.remove(oldName);
    }

    private static String generateName() {
        StringBuilder name;
        do {
            name = new StringBuilder();
            name.appendCodePoint('A' + random.nextInt(LETTERS));
            name.appendCodePoint('A' + random.nextInt(LETTERS));
            name.append(random.nextInt(10));
            name.append(random.nextInt(10));
            name.append(random.nextInt(10));
        } while (names.contains(name.toString()));
        names.add(name.toString());
        return name.toString();
    }

}