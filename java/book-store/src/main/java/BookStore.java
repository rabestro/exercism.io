import java.util.Arrays;
import java.util.List;

public class BookStore {
    private static final double BOOK_PRICE = 8.0;

    public double calculateBasketCost(final List<Integer> booksInStore) {
        int[] books = {0, 0, 0, 0, 0};
        booksInStore.forEach(i -> books[--i]++);
        Arrays.sort(books);

        int groupOf1 = books[4] - books[3];
        int groupOf2 = books[3] - books[2];
        int groupOf3 = books[2] - books[1];
        int groupOf4 = books[1] - books[0];
        int groupOf5 = books[0];
        int combined = Math.min(groupOf3, groupOf5);

        groupOf3 -= combined;
        groupOf5 -= combined;
        groupOf4 += 2 * combined;

        return BOOK_PRICE * (groupOf1
                + 0.95 * 2 * groupOf2
                + 0.90 * 3 * groupOf3
                + 0.80 * 4 * groupOf4
                + 0.75 * 5 * groupOf5);
    }
}
