package DataUtils.Book.Test;

import DataUtils.Book.Book;
import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.Book.Sale;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    User buyer;
    User seller;
    Book book;
    Sale sale;

    @BeforeEach
    void setUp() {
        buyer = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        seller = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, seller);

        sale = new Sale();

        sale.setBook(book);
        sale.setBuyer(buyer);
        sale.setSeller(seller);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buyTest() {
        book.setOwner(buyer);
        sale.buyBook();

        assertEquals(book.getOwner(), buyer);
        assertNotEquals(book.getOwner(), seller);
    }

    @Test
    void buyWithParamTest() {
        book.setOwner(buyer);
        sale.buyBook(seller, buyer, book);

        assertEquals(book.getOwner(), buyer);
        assertNotEquals(book.getOwner(), seller);
    }

    @Test
    void updateTest() {
        book.setOwner(buyer);
        sale.update();

        assertEquals(book.getOwner(), buyer);
        assertNotEquals(book.getOwner(), seller);
    }
}