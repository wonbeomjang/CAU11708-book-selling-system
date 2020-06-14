package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.BookCondition;
import com.wonbeomjang.bookselling.DataUtils.Book.BookOnSale;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookOnBuyBookTest {
    BookOnSale bookOnSale;
    User owner, newOwner;
    @BeforeEach
    void setUp() {
        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        bookOnSale = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner.getUsername());
    }

    @Test
    void setPrice() {
        String price = "10";
        bookOnSale.setPrice(price);
        assertEquals(price, bookOnSale.getPrice());
    }

    @Test
    void setCondition() {
        BookCondition condition = BookCondition.Good;
        bookOnSale.setCondition(condition);
        assertEquals(condition, bookOnSale.getCondition());
    }

    @Test
    void setOwner() {
        newOwner = new User("wonbeomang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "jtiger958", "01037937352");
        bookOnSale.setOwner(newOwner.getUsername());
        assertEquals(newOwner.getUsername(), bookOnSale.getOwner());
        assertNotEquals(owner, bookOnSale.getOwner());
    }
}