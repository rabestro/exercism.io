import static java.util.Objects.requireNonNullElse;

public class Twofer {
    public String twofer(String name) {
        return "One for " + requireNonNullElse(name, "you") + ", one for me.";
    }
}
