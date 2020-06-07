package DataUtils.Book.Test;

import DataUtils.Book.Book;
import DataUtils.Book.BookCondition;
import DataUtils.Book.BookOnSale;
import DataUtils.Book.BookSaleList;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class BookSaleListTest {
    BookSaleList bookSaleList;
    User owner;
    Book book1;
    Book book2;
    Book book3;
    @BeforeEach
    void setUp() {
        bookSaleList = new BookSaleList();
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book1 = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);

        bookSaleList.addBook(book1);
    }

    @Test
    void addBook() {
        int numBooks = bookSaleList.getNumBooks();
        book2 = new BookOnSale("Ubunu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);
        bookSaleList.addBook(book2);
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
        assertEquals(book2, bookSaleList.getBook(numBooks));
    }

    @Test
    void deleteBook() {
        int num_books = bookSaleList.getNumBooks();
        bookSaleList.deleteBook(book1);
        assertEquals(num_books - 1, bookSaleList.getNumBooks());

        book3 = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);
        assertFalse(bookSaleList.deleteBook(book3));
    }
}