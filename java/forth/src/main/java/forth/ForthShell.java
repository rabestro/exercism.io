package forth;

import java.util.List;
import java.util.function.Consumer;

public interface ForthShell extends Consumer<String> {
    void define(String word, List<String> definition);

    List<Integer> getStackAsList();
}
