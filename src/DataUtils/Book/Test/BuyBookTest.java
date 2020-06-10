package DataUtils.Book.Test;

import DataUtils.Book.Book;
import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.Book.BuyBook;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Utils.SetUp;
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
        SetUp.setup();

        buyer = new EndUser("wonbeomjang", "20182592", "장원범", "01037937352", "jtiger958" );
        seller = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, seller.getUsername());

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