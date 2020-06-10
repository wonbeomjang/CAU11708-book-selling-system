package DataUtils.Book.Test;

import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.Book.BookSaleList;
import DataUtils.Book.ModifyBook;
import DataUtils.User.Admin;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ModifyBookTest {
    ModifyBook modifyBook;
    User owner;
    BookOnSale oldBook;
    @BeforeEach
    void setUp() {

        SetUp.setup();

        BookSaleList bookSaleList = BookSaleList.getInstance();

        modifyBook = new ModifyBook();
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        oldBook = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);

        bookSaleList.addBook(oldBook);

    }

    @Test
    void title() {
        BookOnSale newBook = new BookOnSale("Linux", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(oldBook.getTitle(), oldBook.getTitle());
    }

    @Test
    void publicYear() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "2020", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(oldBook.getPublic_year(), oldBook.getPublic_year());
    }

    @Test
    void publisher() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "1999", "김혜성", "장원범", "1000", BookCondition.Excellent, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getPublisher(), oldBook.getPublisher());
    }

    @Test
    void author() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "1999", "장원범", "김혜성", "1000", BookCondition.Excellent, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getAuthor(), oldBook.getAuthor());
    }

    @Test
    void price() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "500", BookCondition.Excellent, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getPrice(), oldBook.getPrice());
    }

    @Test
    void condition() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Good, owner);
        modifyBook.modify(oldBook, newBook);
        assertEquals(newBook.getCondition(), oldBook.getCondition());
    }

    @Test
    void user() {
        BookOnSale newBook = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Good, new Admin("", ""));
        modifyBook.modify(oldBook, newBook);
        assertNotEquals(newBook.getOwner(), oldBook.getOwner());
    }
}