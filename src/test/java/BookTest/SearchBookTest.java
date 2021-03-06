package BookTest;

import com.wonbeomjang.bookselling.DataUtils.Book.*;
import com.wonbeomjang.bookselling.DataUtils.User.User;
import com.wonbeomjang.bookselling.Utils.SetUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchBookTest {
    SearchBook searchBook;
    RegisterBook registerBook;
    User owner;
    Book book;
    Book[] books;

    @BeforeEach
    void setUp() {

        SetUp.setup(true);


        owner = new User("wonbeomjang", "3d4574a464a47ff83f69028d2354771ad371bde7c8a83675feb070f5cbd01a66", "장원범", "01037937352", "jtiger958" );
        registerBook = new RegisterBook();
        searchBook = new SearchBook();
        book = new Book("DB", "123", "2", "장원범", "65000", BookCondition.Fair, owner.getUsername());

        registerBook.addBook(book);
        registerBook.addBook("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        registerBook.addBook("Linux", "2020", "장원범", "장원범", "6000", BookCondition.Fair, owner);
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
        for(Book book : books) assertEquals("장원범", book.getAuthor());

        books = searchBook.search("Linux", BookKeyType.Title);
        for(Book book : books) assertEquals("Linux", book.getTitle());

        books = searchBook.search("wonbeomjang", BookKeyType.Username);
        for(Book book : books) assertEquals("wonbeomjang", book.getOwner());
    }

}