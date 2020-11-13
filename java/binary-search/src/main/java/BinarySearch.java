import java.util.List;
import java.util.stream.Collectors;

public final class BinarySearch {

    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list.stream().sorted().collect(Collectors.toList());
    }

    public int indexOf(int i) {
        return 0;
    }
}