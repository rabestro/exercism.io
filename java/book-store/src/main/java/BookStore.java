import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookStore {
    private static final double BOOK_PRICE = 8.0;
    private static final double[] DISCOUNTS = {1, 0.95, 0.90, 0.80, 0.75};

    public double calculateBasketCost(final List<Integer> booksInStore) {
        // Stage 1
        Integer[] books = {0, 0, 0, 0, 0};
        booksInStore.forEach(i -> books[--i]++);
        Arrays.sort(books, Collections.reverseOrder());

        // Stage 2
        var purchaseCount = books[3] - books[4];
        var price = purchaseCount * 4 * BOOK_PRICE * DISCOUNTS[3];
        books[3] -= purchaseCount;
        books[2] -= purchaseCount;
        books[1] -= purchaseCount;
        books[0] -= purchaseCount;

        // Stage 3
        purchaseCount = Math.min(books[2] - books[3], books[4]);
        price += 2 * purchaseCount * 4 * BOOK_PRICE * DISCOUNTS[3];
        books[4] -= purchaseCount;
        books[3] -= purchaseCount;
        books[2] -= 2 * purchaseCount;
        books[1] -= 2 * purchaseCount;
        books[0] -= 2 * purchaseCount;

        // Stage 4
        for (int i = 4; i >= 0; --i) {
            price += books[i] * (1 + i) * BOOK_PRICE * DISCOUNTS[i];
            for (int k = 0; k <= i; ++k) {
                books[k] -= books[i];
            }
        }
        return price;
    }
}
