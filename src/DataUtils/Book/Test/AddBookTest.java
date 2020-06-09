package DataUtils.Book.Test;

import DataUtils.Book.*;
import DataUtils.User.EndUser;
import DataUtils.User.User;
import DataUtils.User.UserList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddBookTest {
    User owner;
    AddBook addBook;
    BookSaleList bookSaleList;
    Book book;
    int numBooks = 0;
    String userFileName, bookFileName;
    UserList userList;

    @BeforeEach
    void setUp() {
        userFileName = "UserTest.txt";
        bookFileName = "BookTest.txt";
        userList = UserList.getInstance();
        userList.init(userFileName);
        bookSaleList = BookSaleList.getInstance();
        bookSaleList.init(bookFileName, userList);
        addBook = new AddBook();
        owner = new EndUser("wonbeomjang", "20182592", "장원범", "jtiger958", "01037937352");
    }

    @Test
    void addBookWithParam() {
        numBooks = bookSaleList.getNumBooks();
        addBook.addBook("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);
        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
    }

    @Test
    void addBookWithBookObject() {
        book = new BookOnSale("Ubuntu", "1999", "장원범", "장원범", "1000", BookCondition.Excellent, owner);

        numBooks = bookSaleList.getNumBooks();
        addBook.addBook(book);

        assertEquals(numBooks + 1, bookSaleList.getNumBooks());
        assertTrue(bookSaleList.contain(book));
    }

}