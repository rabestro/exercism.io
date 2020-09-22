import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {

    List flatten(List list) {
        return (List) list.stream().flatMap(o -> {
            if (o instanceof List) {
                return flatten((List) o).stream();
            } else {
                return Stream.of(o);
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
}