package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {
    SearchBook searchBook;
    AddBook addBook;
    User owner;
    Book book;
    Book[] books;

    @BeforeEach
    void setUp() {

        SetUp.setup();


        owner = new EndUser("wonbeomjang", "20182592", "장원범", "01037937352", "jtiger958" );
        addBook = new AddBook();
        searchBook = new SearchBook();
        book = new BookOnSale("DB", "123", "2", "장원범", "65000", BookCondition.Fair, owner.getUsername());

        addBook.addBook(book);
        addBook.addBook("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        addBook.addBook("Linux", "2020", "장원범", "장원범", "6000", BookCondition.Fair, owner);
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
        for(Book book: books) assertEquals("장원범", book.getAuthor());

        books = searchBook.search("Linux", BookKeyType.Title);
        for(Book book: books) assertEquals("Linux", book.getTitle());

        books = searchBook.search("wonbeomjang", BookKeyType.Username);
        for(Book book: books) assertEquals("wonbeomjang", book.getOwner());
    }

}