package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class AddBookTest {
    User owner;
    AddBook addBook;
    BookSaleList bookSaleList;
    Book book;
    int numBooks = 0;

    @BeforeEach
    void setUp() {
        bookSaleList = new BookSaleList();
        addBook = new AddBook(bookSaleList);
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");

        addBook.setTitle("Linux");
        addBook.setAuthor("자우언범");
        addBook.setPublicYear(Year.of(1341));
        addBook.setPublisher("장원범");
        addBook.setPrice(100);
        addBook.setOwner(owner);
        addBook.setCondition(BookCondition.Excellent);
    }

    @Test
    void addBookWithParam() {
        numBooks = bookSaleList.getNumBooks();
        addBook.addBook("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
    }

    @Test
    void addBookWithBookObject() {
        book = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);

        numBooks = bookSaleList.getNumBooks();
        addBook.addBook(book);

        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
        assertTrue(bookSaleList.contain(book));
    }

    @Test
    void addBook() {
        numBooks = bookSaleList.getNumBooks();
        addBook.addBook();
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
    }

    @Test
    void update() {
        numBooks = bookSaleList.getNumBooks();
        addBook.update();
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
    }
}