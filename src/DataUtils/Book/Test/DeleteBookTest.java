package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import DataUtils.User.UserList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class DeleteBookTest {
    User owner, other;
    DeleteBook deleteBook;
    BookSaleList bookSaleList;
    AddBook addBook;
    Book book;

    int numBooks;
    UserList userList;
    String userFileName, bookFileName;

    @BeforeEach
    void setUp() {
        userFileName = "UserTest.txt";
        bookFileName = "BookTest.txt";
        userList = new UserList(userFileName);
        bookSaleList = new BookSaleList(bookFileName, userList);

        addBook = new AddBook(bookSaleList);
        deleteBook = new DeleteBook(bookSaleList);
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        other = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
        book = new BookOnSale("Ubuntu", Year.of(1999), "장원범", "장원범", 1000, BookCondition.Excellent, owner);

        addBook.addBook(book);
    }

    @Test
    void deleteBook() {
        numBooks = bookSaleList.getNumBooks();
        deleteBook.deleteBook(owner, book);
        assertEquals(numBooks - 1, bookSaleList.getNumBooks());
        assertFalse(bookSaleList.contain(book));
        assertFalse(deleteBook.deleteBook(other, book));
    }
}