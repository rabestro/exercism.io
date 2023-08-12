package forth;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public interface ForthEngine extends Consumer<String>, Supplier<List<Integer>> {
}
