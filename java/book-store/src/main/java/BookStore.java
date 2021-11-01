import java.util.Arrays;
import java.util.List;

public class BookStore {
    private static final double BOOK_PRICE = 8.0;

    public double calculateBasketCost(final List<Integer> booksInStore) {
        int[] books = {0, 0, 0, 0, 0};
        booksInStore.forEach(i -> books[--i]++);
        Arrays.sort(books);

        int p1 = books[4] - books[3];
        int p2 = books[3] - books[2];
        int p3 = books[2] - books[1];
        int p4 = books[1] - books[0];
        int pc = Math.min(p3, books[0]);

        return BOOK_PRICE * (p1
                + 0.95 * 2 * p2
                + 0.90 * 3 * (p3 - pc)
                + 0.80 * 4 * (p4 + 2 * pc)
                + 0.75 * 5 * (books[0] - pc));
    }
}
