package DataUtils.Book.Test;

import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class BookOnSaleTest {
    BookOnSale bookOnSale;
    User owner, newOwner;
    @BeforeEach
    void setUp() {
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        bookOnSale = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);
    }

    @Test
    void setPrice() {
        int price = 10;
        bookOnSale.setPrice(price);
        assertEquals(bookOnSale.getPrice(), price);
    }

    @Test
    void setCondition() {
        BookCondition condition = BookCondition.Good;
        bookOnSale.setCondition(condition);
        assertEquals(bookOnSale.getCondition(), condition);
    }

    @Test
    void setOwner() {
        newOwner = new EndUser("wonbeomang", "20182592", "장원범", "jtiger958", "01037937352");
        bookOnSale.setOwner(newOwner);
        assertEquals(bookOnSale.getOwner(), newOwner);
        assertNotEquals(bookOnSale.getOwner(), owner);
    }
}