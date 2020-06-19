package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.Book;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookOnBuyBookTest {
    Book book;
    User owner, newOwner;
    @BeforeEach
    void setUp() {
        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        book = new Book("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
    }

    @Test
    void setPrice() {
        String price = "10";
        book.setPrice(price);
        assertEquals(price, book.getPrice());
    }

    @Test
    void setCondition() {
        BookCondition condition = BookCondition.Good;
        book.setCondition(condition);
        assertEquals(condition, book.getCondition());
    }

    @Test
    void setOwner() {
        newOwner = new User("wonbeomang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        book.setOwner(newOwner.getUsername());
        assertEquals(newOwner.getUsername(), book.getOwner());
        assertNotEquals(owner, book.getOwner());
    }
}