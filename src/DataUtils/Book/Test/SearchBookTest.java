package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {
    BookSaleList bookSaleList;
    SearchBook searchBook;
    AddBook addBook;
    User owner;
    Book book;
    Book[] books;

    @BeforeEach
    void setUp() {
        bookSaleList = new BookSaleList();
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        addBook = new AddBook(bookSaleList);
        searchBook = new SearchBook(bookSaleList);
        book = new BookOnSale("DB", Year.of(123), "2", "장원범", 65000, BookCondition.Fair, owner);

        addBook.addBook(book);
        addBook.addBook("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);
        addBook.addBook("Linux", Year.of(2020), "장원범", "장원범", 6000, BookCondition.Fair, owner);
    }

    @Test
    void compare() {
        assertTrue(searchBook.compareByKey(book, "장원범", BookKeyType.Author));
        assertTrue(searchBook.compareByKey(book, "DB", BookKeyType.Title));
        assertTrue(searchBook.compareByKey(book, "wonbeomjang", BookKeyType.Username));

        assertFalse(searchBook.compareByKey(book, "장1원범", BookKeyType.Author));
        assertFalse(searchBook.compareByKey(book, "D1B", BookKeyType.Title));
        assertFalse(searchBook.compareByKey(book, "won1beomjang", BookKeyType.Username));
    }

    @Test
    void search() {
        books = searchBook.search("장원범", BookKeyType.Author);
        assertEquals(3, books.length);
        books = searchBook.search("Linux", BookKeyType.Title);
        assertEquals(1, books.length);
        books = searchBook.search("123", BookKeyType.ISBN);
        assertEquals(3, books.length);
        books = searchBook.search("wonbeomjang", BookKeyType.Username);
        assertEquals(3, books.length);
    }

    @Test
    void getInfo() {
        String[] strings;
        searchBook.search("장원범", BookKeyType.Author);
        strings = searchBook.getInfo();
        assertEquals(3, strings.length);
    }
}