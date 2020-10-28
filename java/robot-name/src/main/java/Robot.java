import java.util.Random;

final class Robot {
    private static final Random random = new Random();
    private static final int LETTERS = 1 + 'Z' - 'A';
    private String name;

    {
        name = generateName();
    }

    public String getName() {
        return name;
    }

    public void reset() {
        name = generateName();
    }

    private static String generateName() {
        final var name = new StringBuilder();
        name.appendCodePoint('A' + random.nextInt(LETTERS));
        name.appendCodePoint('A' + random.nextInt(LETTERS));
        name.append(random.nextInt(10));
        name.append(random.nextInt(10));
        name.append(random.nextInt(10));
        return name.toString();
    }
}