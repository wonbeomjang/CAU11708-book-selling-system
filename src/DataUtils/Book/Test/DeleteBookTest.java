package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DeleteBookTest {
    User owner;
    DeleteBook deleteBook;
    BookSaleList bookSaleList;
    AddBook addBook;
    Book book;

    int numBooks = 0;
    @BeforeEach
    void setUp() {
        bookSaleList = new BookSaleList();
        addBook = new AddBook(bookSaleList);
        deleteBook = new DeleteBook(bookSaleList);
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);

        addBook.addBook(book);
    }

    @Test
    void deleteBook() {
        numBooks = bookSaleList.getNumBooks();
        deleteBook.deleteBook(book);
        assertEquals(numBooks - 1, bookSaleList.getNumBooks());
        assertFalse(bookSaleList.contain(book));
    }
}