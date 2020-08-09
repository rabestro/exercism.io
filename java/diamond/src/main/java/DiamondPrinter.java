import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class DiamondPrinter {

    List<String> printToList(char a) {
        final int d = a - 'A';

        return IntStream.rangeClosed(0, d * 2)
                .mapToObj(i -> {
                    if (i == 0 || i == 2 * d) {
                        return " ".repeat(d) + "A" + " ".repeat(d);
                    } else if (i < d) {
                        return " ".repeat(d - i)
                                + (char) ('A' + i)
                                + " ".repeat(2 * i - 1)
                                + (char) ('A' + i)
                                + " ".repeat(d - i);
                    } else if (i > d) {
                        return " ".repeat(i - d)
                                + (char) ('A' + 2 * d - i)
                                + " ".repeat(4 * d - 2 * i - 1)
                                + (char) ('A' + 2 * d - i)
                                + " ".repeat(i - d);
                    }
                    return a + " ".repeat(2 * d - 1) + a;
                })
                .collect(Collectors.toList());
    }

}
