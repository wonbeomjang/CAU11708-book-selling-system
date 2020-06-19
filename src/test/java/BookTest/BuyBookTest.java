package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.Book.BuyBook;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BuyBookTest {
    User buyer;
    User seller;
    Book book;
    BuyBook buyBook;

    @BeforeEach
    void setUp() {
        SetUp.setup(true);

        buyer = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        seller = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        book = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, seller.getUsername());

        buyBook = new BuyBook();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buy() {
        book.setOwner(buyer.getUsername());
        buyBook.buyBook(buyer, book);

        assertEquals(book.getOwner(), buyer.getUsername());
        assertNotEquals(book.getOwner(), seller);
    }
}