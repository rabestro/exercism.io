import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Flattener {

    List flatten(List list) {
        return (List) flatten(list.stream()).collect(Collectors.toList());
    }

    Stream flatten(Stream stream) {
        return stream.flatMap(o -> o instanceof List ? flatten(((List) o).stream()) : Stream.of(o))
                .filter(Objects::nonNull);
    }
}