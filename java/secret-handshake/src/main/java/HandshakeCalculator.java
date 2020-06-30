import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {
        final var result = Stream.of(Signal.values())
                .filter(e -> 0 < (number & 1 << e.ordinal()))
                .collect(Collectors.toList());

        if (0 < (number & 1 << 4)) {
            Collections.reverse(result);
        }
        return result;
    }

}
