import java.util.List;

import static java.util.Arrays.binarySearch;

public final class BinarySearch {

    private int[] arr;

    public BinarySearch(List<Integer> list) {
        this.arr = list.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public int indexOf(int i) throws ValueNotFoundException {
        int result = binarySearch(arr, i);
        if (result < 0) {
            throw new ValueNotFoundException("Value not in array");
        }
        return result;
    }
}