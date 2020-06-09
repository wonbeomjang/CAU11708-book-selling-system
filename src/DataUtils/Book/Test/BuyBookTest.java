package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import DataUtils.User.UserList;
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
        String userFileName = "UserTest.txt";
        String bookFileName = "BookTest.txt";
        UserList userList = UserList.getInstance();
        BookSaleList bookSaleList = BookSaleList.getInstance();
        bookSaleList.init(bookFileName, userList);

        buyer = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        seller = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, seller);

        buyBook = new BuyBook();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buy() {
        book.setOwner(buyer);
        buyBook.buyBook(buyer, book);

        assertEquals(book.getOwner(), buyer);
        assertNotEquals(book.getOwner(), seller);
    }
}