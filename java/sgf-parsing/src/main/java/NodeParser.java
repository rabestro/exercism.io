import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NodeParser implements Function<String, Map<String, List<String>>> {
    private static final Pattern SGF_NODE =
            Pattern.compile("(\\p{Lu}{1,2})(\\[.+?(?<!\\\\)]){1,5}");

    @Override
    public Map<String, List<String>> apply(String node) {
        return SGF_NODE.matcher(node)
                .results()
                .collect(Collectors.toMap(
                        e -> e.group(1),
                        e -> List.of(e.group(2))));
    }

}
